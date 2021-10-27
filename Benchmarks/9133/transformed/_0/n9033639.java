class n9033639 {
	public void testHttpsConnection() throws Throwable {
		setUpStoreProperties();
		try {
			SSLContext qgRF6Veh = getContext();
			ServerSocket gew5HCTN = qgRF6Veh.getServerSocketFactory().createServerSocket(0);
			TestHostnameVerifier YM42MwDh = new TestHostnameVerifier();
			HttpsURLConnection.setDefaultHostnameVerifier(YM42MwDh);
			URL Smw9KTpq = new URL("https://localhost:" + gew5HCTN.getLocalPort());
			HttpsURLConnection OZTUgutL = (HttpsURLConnection) Smw9KTpq.openConnection();
			SSLSocket BFCWDuEv = (SSLSocket) doInteraction(OZTUgutL, gew5HCTN);
			checkConnectionStateParameters(OZTUgutL, BFCWDuEv);
			OZTUgutL.connect();
		} finally {
			tearDownStoreProperties();
		}
	}

}