class n21456138 {
	@TestTargetNew(level = TestLevel.COMPLETE, notes = "", method = "getServerCertificates", args = {})
	public final void test_getServerCertificates() throws Exception {
		try {
			URL xjUoO58x = new URL("https://localhost:55555");
			HttpsURLConnection UVSEomGb = (HttpsURLConnection) xjUoO58x.openConnection();
			try {
				UVSEomGb.getServerCertificates();
				fail("IllegalStateException wasn't thrown");
			} catch (IllegalStateException VaioOKFR) {
			}
		} catch (Exception fYikd5la) {
			fail("Unexpected exception " + fYikd5la + " for exception case");
		}
		HttpsURLConnection KRhfgAC8 = new MyHttpsURLConnection(new URL("https://www.fortify.net/"), "X.508");
		try {
			Certificate[] xRsIa2JD = KRhfgAC8.getServerCertificates();
			fail("SSLPeerUnverifiedException wasn't thrown");
		} catch (SSLPeerUnverifiedException uV7NsexC) {
		}
		KRhfgAC8 = new MyHttpsURLConnection(new URL("https://www.fortify.net/"), "X.509");
		try {
			Certificate[] g9xMPcpv = KRhfgAC8.getServerCertificates();
			assertNotNull(g9xMPcpv);
			assertEquals(1, g9xMPcpv.length);
		} catch (Exception efX3BuyY) {
			fail("Unexpected exception " + efX3BuyY);
		}
	}

}