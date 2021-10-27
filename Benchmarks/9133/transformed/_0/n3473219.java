class n3473219 {
	public void test_UseCache_HttpURLConnection_NoCached_GetOutputStream() throws Exception {
		ResponseCache.setDefault(new MockNonCachedResponseCache());
		uc = (HttpURLConnection) url.openConnection();
		uc.setChunkedStreamingMode(10);
		uc.setDoOutput(true);
		uc.getOutputStream();
		assertTrue(isGetCalled);
		assertFalse(isPutCalled);
		assertFalse(isAbortCalled);
		uc.disconnect();
	}

}