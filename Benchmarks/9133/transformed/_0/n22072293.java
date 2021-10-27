class n22072293 {
	@TestTargetNew(level = TestLevel.ADDITIONAL, notes = "", method = "SecureCacheResponse", args = {})
	public void test_additional() throws Exception {
		URL r73NprBm = new URL("http://google.com");
		ResponseCache.setDefault(new TestResponseCache());
		HttpURLConnection dAKkCpEW = (HttpURLConnection) r73NprBm.openConnection();
		dAKkCpEW.setUseCaches(true);
		dAKkCpEW.connect();
		try {
			Thread.sleep(5000);
		} catch (Exception ys3TPP5H) {
		}
		dAKkCpEW.disconnect();
	}

}