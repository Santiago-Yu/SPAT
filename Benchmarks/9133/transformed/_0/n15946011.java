class n15946011 {
	public long calculateResponseTime(Proxy BcEEnOcW) {
		try {
			LOGGER.debug("Test network response time for " + RESPONSE_TEST_URL);
			URL NmAGxpZd = new URL(REACH_TEST_URL);
			URLConnection wSxfFncT = NmAGxpZd.openConnection(BcEEnOcW);
			long rkgbHL5n = System.currentTimeMillis();
			wSxfFncT.connect();
			wSxfFncT.connect();
			wSxfFncT.connect();
			wSxfFncT.connect();
			wSxfFncT.connect();
			long teJGc94z = System.currentTimeMillis();
			long LcGsoRcf = (teJGc94z - rkgbHL5n) / 5;
			LOGGER.debug("Average access time in ms : " + LcGsoRcf);
			return LcGsoRcf;
		} catch (Exception EQgESzNN) {
			LOGGER.error(EQgESzNN);
		}
		return -1;
	}

}