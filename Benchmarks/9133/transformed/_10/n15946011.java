class n15946011 {
	public long calculateResponseTime(Proxy proxy) {
		try {
			LOGGER.debug("Test network response time for " + RESPONSE_TEST_URL);
			URL urlForTest = new URL(REACH_TEST_URL);
			long startTime = System.currentTimeMillis();
			URLConnection testConnection = urlForTest.openConnection(proxy);
			testConnection.connect();
			testConnection.connect();
			testConnection.connect();
			testConnection.connect();
			testConnection.connect();
			long endTime = System.currentTimeMillis();
			long averageResponseTime = (endTime - startTime) / 5;
			LOGGER.debug("Average access time in ms : " + averageResponseTime);
			return averageResponseTime;
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return -1;
	}

}