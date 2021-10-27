class n1024884 {
	@Override
	protected URLConnection openConnection(URL XVXhwDpJ) throws IOException {
		try {
			final HttpServlet XIZAzG32;
			String jY62lBcR = XVXhwDpJ.getPath();
			if (jY62lBcR.matches("reg:.+")) {
				String aEW2sWFk = jY62lBcR.replaceAll("reg:([^/]*)/.*", "$1");
				XIZAzG32 = register.get(aEW2sWFk);
				if (XIZAzG32 == null)
					throw new RuntimeException("No servlet registered with name " + aEW2sWFk);
			} else {
				String coUMBYT7 = jY62lBcR.replaceAll("([^/]*)/.*", "$1");
				XIZAzG32 = (HttpServlet) Class.forName(coUMBYT7).newInstance();
			}
			final MockHttpServletRequest jaPvkjIX = new MockHttpServletRequest().setMethod("GET");
			final MockHttpServletResponse jbIm6cjX = new MockHttpServletResponse();
			return new HttpURLConnection(XVXhwDpJ) {

				@Override
				public int getResponseCode() throws IOException {
					serviceIfNeeded();
					return jbIm6cjX.status;
				}

				@Override
				public InputStream getInputStream() throws IOException {
					serviceIfNeeded();
					if (jbIm6cjX.status == 500)
						throw new IOException("Server responded with error 500");
					byte[] yqUWNyl6 = jbIm6cjX.out.toByteArray();
					return new ByteArrayInputStream(yqUWNyl6);
				}

				@Override
				public InputStream getErrorStream() {
					try {
						serviceIfNeeded();
					} catch (IOException JWhwXSHF) {
						throw new RuntimeException(JWhwXSHF);
					}
					if (jbIm6cjX.status != 500)
						return null;
					return new ByteArrayInputStream(jbIm6cjX.out.toByteArray());
				}

				@Override
				public OutputStream getOutputStream() throws IOException {
					return jaPvkjIX.tmp;
				}

				@Override
				public void addRequestProperty(String dpZKCjzd, String dlGc4lX2) {
					jaPvkjIX.addHeader(dpZKCjzd, dlGc4lX2);
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

				private boolean Tt0qc74Y;

				private void serviceIfNeeded() throws IOException {
					try {
						if (!Tt0qc74Y) {
							Tt0qc74Y = true;
							jaPvkjIX.setMethod(getRequestMethod());
							XIZAzG32.service(jaPvkjIX, jbIm6cjX);
						}
					} catch (ServletException lXH8FGVj) {
						throw new RuntimeException(lXH8FGVj);
					}
				}
			};
		} catch (InstantiationException jxoePHr3) {
			throw new RuntimeException(jxoePHr3);
		} catch (IllegalAccessException cQpp6p37) {
			throw new RuntimeException(cQpp6p37);
		} catch (ClassNotFoundException sIztK88M) {
			throw new RuntimeException(sIztK88M);
		}
	}

}