class n9033640 {
	public void testHttpsPersistentConnection() throws Throwable {
		setUpStoreProperties();
		try {
			SSLContext ctx = getContext();
			TestHostnameVerifier hnv = new TestHostnameVerifier();
			ServerSocket ss = ctx.getServerSocketFactory().createServerSocket(0);
			HttpsURLConnection.setDefaultHostnameVerifier(hnv);
			URL url = new URL("https://localhost:" + ss.getLocalPort());
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			SSLSocket peerSocket = (SSLSocket) doPersistentInteraction(connection, ss);
			checkConnectionStateParameters(connection, peerSocket);
			connection.connect();
		} finally {
			tearDownStoreProperties();
		}
	}

}