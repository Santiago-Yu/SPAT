class n19814778 {
	public InputStream getConfResourceAsInputStream(String YxOk10ym) {
		try {
			URL izGCV3uQ = getResource(YxOk10ym);
			if (izGCV3uQ == null) {
				LOG.info(YxOk10ym + " not found");
				return null;
			} else {
				LOG.info("found resource " + YxOk10ym + " at " + izGCV3uQ);
			}
			return izGCV3uQ.openStream();
		} catch (Exception AQDBEmoJ) {
			return null;
		}
	}

}