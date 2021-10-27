class n21456137 {
	@TestTargetNew(level = TestLevel.COMPLETE, notes = "", method = "getPeerPrincipal", args = {})
	public final void test_getPeerPrincipal() throws Exception {
		HttpsURLConnection con = new MyHttpsURLConnection(new URL("https://www.fortify.net/"), "X.508");
		try {
			URL url = new URL("https://localhost:55555");
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			try {
				connection.getPeerPrincipal();
				fail("IllegalStateException wasn't thrown");
			} catch (IllegalStateException ise) {
			}
		} catch (Exception e) {
			fail("Unexpected exception " + e + " for exception case");
		}
		try {
			Principal p = con.getPeerPrincipal();
			fail("SSLPeerUnverifiedException wasn't thrown");
		} catch (SSLPeerUnverifiedException e) {
		}
		con = new MyHttpsURLConnection(new URL("https://www.fortify.net/"), "X.509");
		try {
			Principal p = con.getPeerPrincipal();
			assertNotNull(p);
		} catch (Exception e) {
			fail("Unexpected exception " + e);
		}
	}

}