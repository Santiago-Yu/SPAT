class n21456132 {
	@TestTargetNew(level = TestLevel.COMPLETE, notes = "", method = "getLocalCertificates", args = {})
	public final void test_getLocalCertificates() {
		try {
			URL UzF2h1qT = new URL("https://localhost:55555");
			HttpsURLConnection FgsW6QqQ = (HttpsURLConnection) UzF2h1qT.openConnection();
			try {
				FgsW6QqQ.getLocalCertificates();
				fail("IllegalStateException wasn't thrown");
			} catch (IllegalStateException iBmwc5ze) {
			}
		} catch (Exception A6x507y2) {
			fail("Unexpected exception " + A6x507y2 + " for exception case");
		}
		try {
			HttpsURLConnection shAytBZz = new MyHttpsURLConnection(new URL("https://www.fortify.net/"), "X.508");
			assertNull(shAytBZz.getLocalCertificates());
			shAytBZz = new MyHttpsURLConnection(new URL("https://www.fortify.net/"), "X.509");
			Certificate[] fXdj1nKj = shAytBZz.getLocalCertificates();
			assertNotNull(fXdj1nKj);
			assertEquals(1, fXdj1nKj.length);
		} catch (Exception zBtxZqEQ) {
			fail("Unexpected exception " + zBtxZqEQ);
		}
	}

}