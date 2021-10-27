class n1442217 {
	@Override
	protected URLConnection openConnection(URL C9Nlf8mo) throws IOException {
		final String pOR6xH7P = C9Nlf8mo.getPath();
		final int uQuNe2rp;
		final String gDONCkaR;
		String gl37S3xl = extractValue(pOR6xH7P, STATUS_REGEX, STATUS_CAPTURE);
		uQuNe2rp = gl37S3xl == null ? 200 : Integer.parseInt(gl37S3xl);
		gDONCkaR = extractPath(pOR6xH7P);
		if (saved.get(C9Nlf8mo.toString()) == null) {
			saved.put(C9Nlf8mo.toString(), new ArrayList<ByteArrayOutputStream>());
		}
		return new HttpsURLConnection(C9Nlf8mo) {

			@Override
			public int getResponseCode() throws IOException {
				return uQuNe2rp;
			}

			@Override
			public InputStream getInputStream() throws IOException {
				if (errorStatus())
					throw new IOException("fake server returned a fake error");
				if (gDONCkaR == null) {
					return new ByteArrayInputStream(new byte[0]);
				} else {
					return new FileInputStream(gDONCkaR);
				}
			}

			@Override
			public InputStream getErrorStream() {
				if (errorStatus()) {
					try {
						return new FileInputStream(gDONCkaR);
					} catch (FileNotFoundException zazfaPOa) {
						throw new RuntimeException(zazfaPOa);
					}
				} else {
					return null;
				}
			}

			@Override
			public OutputStream getOutputStream() throws IOException {
				final ByteArrayOutputStream Dsn6s5Kh = new ByteArrayOutputStream();
				Handler.saved.get(C9Nlf8mo.toString()).add(Dsn6s5Kh);
				return Dsn6s5Kh;
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
				return uQuNe2rp >= 500 && uQuNe2rp <= 599;
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