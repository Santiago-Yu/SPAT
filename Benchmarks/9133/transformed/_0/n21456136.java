class n21456136 {
	@TestTargetNew(level = TestLevel.COMPLETE, notes = "", method = "getLocalPrincipal", args = {})
	public final void test_getLocalPrincipal() {
		try {
			URL xAxJdV5n = new URL("https://localhost:55555");
			HttpsURLConnection BGxKBlPj = (HttpsURLConnection) xAxJdV5n.openConnection();
			try {
				BGxKBlPj.getLocalPrincipal();
				fail("IllegalStateException wasn't thrown");
			} catch (IllegalStateException Es5AT6AK) {
			}
		} catch (Exception nncJfeBx) {
			fail("Unexpected exception " + nncJfeBx + " for exception case");
		}
		try {
			HttpsURLConnection q9aLXsHe = new MyHttpsURLConnection(new URL("https://www.fortify.net/"), "X.508");
			assertNull(q9aLXsHe.getLocalPrincipal());
			q9aLXsHe = new MyHttpsURLConnection(new URL("https://www.fortify.net/"), "X.509");
			assertNotNull("Local principal is null", q9aLXsHe.getLocalPrincipal());
		} catch (Exception VnTo3r2T) {
			fail("Unexpected exception " + VnTo3r2T);
		}
	}

}