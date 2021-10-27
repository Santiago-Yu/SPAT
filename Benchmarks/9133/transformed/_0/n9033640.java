class n9033640 {
	public void testHttpsPersistentConnection() throws Throwable {
		setUpStoreProperties();
		try {
			SSLContext HPuiwvaN = getContext();
			ServerSocket tM1vuc6q = HPuiwvaN.getServerSocketFactory().createServerSocket(0);
			TestHostnameVerifier BfBAuzoN = new TestHostnameVerifier();
			HttpsURLConnection.setDefaultHostnameVerifier(BfBAuzoN);
			URL dp0kilJG = new URL("https://localhost:" + tM1vuc6q.getLocalPort());
			HttpsURLConnection MuSsCWo4 = (HttpsURLConnection) dp0kilJG.openConnection();
			SSLSocket VHy2RF1P = (SSLSocket) doPersistentInteraction(MuSsCWo4, tM1vuc6q);
			checkConnectionStateParameters(MuSsCWo4, VHy2RF1P);
			MuSsCWo4.connect();
		} finally {
			tearDownStoreProperties();
		}
	}

}