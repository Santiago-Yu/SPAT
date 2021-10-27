class n1024884 {
	@Override
	protected URLConnection openConnection(URL url) throws IOException {
		try {
			String path = url.getPath();
			final HttpServlet servlet;
			if (path.matches("reg:.+")) {
				String registerName = path.replaceAll("reg:([^/]*)/.*", "$1");
				servlet = register.get(registerName);
				if (servlet == null)
					throw new RuntimeException("No servlet registered with name " + registerName);
			} else {
				String servletClassName = path.replaceAll("([^/]*)/.*", "$1");
				servlet = (HttpServlet) Class.forName(servletClassName).newInstance();
			}
			final MockHttpServletResponse resp = new MockHttpServletResponse();
			final MockHttpServletRequest req = new MockHttpServletRequest().setMethod("GET");
			return new HttpURLConnection(url) {

				@Override
				public int getResponseCode() throws IOException {
					serviceIfNeeded();
					return resp.status;
				}

				@Override
				public InputStream getInputStream() throws IOException {
					serviceIfNeeded();
					if (resp.status == 500)
						throw new IOException("Server responded with error 500");
					byte[] array = resp.out.toByteArray();
					return new ByteArrayInputStream(array);
				}

				@Override
				public InputStream getErrorStream() {
					if (resp.status != 500)
						return null;
					try {
						serviceIfNeeded();
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
					return new ByteArrayInputStream(resp.out.toByteArray());
				}

				@Override
				public OutputStream getOutputStream() throws IOException {
					return req.tmp;
				}

				@Override
				public void addRequestProperty(String key, String value) {
					req.addHeader(key, value);
				}

				@Override
				public void connect() throws IOException {
				}

				@Override
				public boolean usingProxy() {
					return false;
				}

				@Override
				public void disconnect() {
				}

				private boolean called;

				private void serviceIfNeeded() throws IOException {
					try {
						if (!called) {
							called = true;
							req.setMethod(getRequestMethod());
							servlet.service(req, resp);
						}
					} catch (ServletException e) {
						throw new RuntimeException(e);
					}
				}
			};
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}