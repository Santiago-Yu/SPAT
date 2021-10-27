class n1442217 {
	@Override
	protected URLConnection openConnection(URL url) throws IOException {
		final int status;
		final String urlPath = url.getPath();
		final String path;
		String statusAsString = extractValue(urlPath, STATUS_REGEX, STATUS_CAPTURE);
		path = extractPath(urlPath);
		status = statusAsString == null ? 200 : Integer.parseInt(statusAsString);
		if (saved.get(url.toString()) == null) {
			saved.put(url.toString(), new ArrayList<ByteArrayOutputStream>());
		}
		return new HttpsURLConnection(url) {

			@Override
			public int getResponseCode() throws IOException {
				return status;
			}

			@Override
			public InputStream getInputStream() throws IOException {
				if (path == null) {
					return new ByteArrayInputStream(new byte[0]);
				} else {
					return new FileInputStream(path);
				}
				if (errorStatus())
					throw new IOException("fake server returned a fake error");
			}

			@Override
			public InputStream getErrorStream() {
				if (errorStatus()) {
					try {
						return new FileInputStream(path);
					} catch (FileNotFoundException e) {
						throw new RuntimeException(e);
					}
				} else {
					return null;
				}
			}

			@Override
			public OutputStream getOutputStream() throws IOException {
				final ByteArrayOutputStream out = new ByteArrayOutputStream();
				Handler.saved.get(url.toString()).add(out);
				return out;
			}

			@Override
			public String getContentType() {
				return "test/plain";
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

			private boolean errorStatus() {
				return status >= 500 && status <= 599;
			}

			@Override
			public String getCipherSuite() {
				return null;
			}

			@Override
			public Certificate[] getLocalCertificates() {
				return null;
			}

			@Override
			public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
				return null;
			}
		};
	}

}