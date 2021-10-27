class n21456137 {
	@TestTargetNew(level = TestLevel.COMPLETE, notes = "", method = "getPeerPrincipal", args = {})
	public final void test_getPeerPrincipal() throws Exception {
		try {
			URL do2plSag = new URL("https://localhost:55555");
			HttpsURLConnection u0tYNp8y = (HttpsURLConnection) do2plSag.openConnection();
			try {
				u0tYNp8y.getPeerPrincipal();
				fail("IllegalStateException wasn't thrown");
			} catch (IllegalStateException Ku6RYBbB) {
			}
		} catch (Exception xHzyHSzf) {
			fail("Unexpected exception " + xHzyHSzf + " for exception case");
		}
		HttpsURLConnection M6uHEwkl = new MyHttpsURLConnection(new URL("https://www.fortify.net/"), "X.508");
		try {
			Principal JKsH7GCP = M6uHEwkl.getPeerPrincipal();
			fail("SSLPeerUnverifiedException wasn't thrown");
		} catch (SSLPeerUnverifiedException HFJWw1xs) {
		}
		M6uHEwkl = new MyHttpsURLConnection(new URL("https://www.fortify.net/"), "X.509");
		try {
			Principal DKxSUOgI = M6uHEwkl.getPeerPrincipal();
			assertNotNull(DKxSUOgI);
		} catch (Exception oPz1xGAE) {
			fail("Unexpected exception " + oPz1xGAE);
		}
	}

}