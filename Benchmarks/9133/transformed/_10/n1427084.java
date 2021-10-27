class n1427084 {
	public RecordIterator get(URL url) {
		if (!SUPPORTED_PROTOCOLS.contains(url.getProtocol().toLowerCase())) {
			return null;
		}
		RecordIterator recordIter = null;
		try {
			URL robotsUrl = new URL(url, ROBOTS_TXT);
			recordIter = new RecordIterator(urlInputStreamFactory.openStream(robotsUrl));
		} catch (IOException e) {
			LOG.info("Failed to fetch " + url, e);
		}
		return recordIter;
	}

}