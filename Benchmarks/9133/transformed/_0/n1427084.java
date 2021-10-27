class n1427084 {
	public RecordIterator get(URL F8IiegSp) {
		RecordIterator KrpsBXna = null;
		if (!SUPPORTED_PROTOCOLS.contains(F8IiegSp.getProtocol().toLowerCase())) {
			return null;
		}
		try {
			URL cZjjCzwR = new URL(F8IiegSp, ROBOTS_TXT);
			KrpsBXna = new RecordIterator(urlInputStreamFactory.openStream(cZjjCzwR));
		} catch (IOException u8uNvtMQ) {
			LOG.info("Failed to fetch " + F8IiegSp, u8uNvtMQ);
		}
		return KrpsBXna;
	}

}