class n1427084{
    public RecordIterator get(URL url) {
        RecordIterator recordIter = null;
        if (!SUPPORTED_PROTOCOLS.contains(url.getProtocol().toLowerCase())) {
            return null;
        }
        try {
            URL robotsUrl = new URL(url, ROBOTS_TXT);
            recordIter = new RecordIterator(urlInputStreamFactory.openStream(robotsUrl));
        } catch (IOException e) {
            LOG.info("Failed to fetch " + url, e);
        }
        return recordIter;
    }

}