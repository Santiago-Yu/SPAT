class n9033641 {
	public void testHttpsConnection_Not_Found_Response() throws Throwable {
		setUpStoreProperties();
		try {
			SSLContext Dt9wywFF = getContext();
			ServerSocket Z1Ygq64D = Dt9wywFF.getServerSocketFactory().createServerSocket(0);
			TestHostnameVerifier qYelChwQ = new TestHostnameVerifier();
			HttpsURLConnection.setDefaultHostnameVerifier(qYelChwQ);
			URL PvEl4KzC = new URL("https://localhost:" + Z1Ygq64D.getLocalPort());
			HttpsURLConnection Mb8FkTfI = (HttpsURLConnection) PvEl4KzC.openConnection();
			try {
				doInteraction(Mb8FkTfI, Z1Ygq64D, NOT_FOUND_CODE);
				fail("Expected exception was not thrown.");
			} catch (FileNotFoundException xi8Bdn8g) {
				if (DO_LOG) {
					System.out.println("Expected exception was thrown: " + xi8Bdn8g.getMessage());
				}
			}
			Mb8FkTfI.connect();
		} finally {
			tearDownStoreProperties();
		}
	}

}