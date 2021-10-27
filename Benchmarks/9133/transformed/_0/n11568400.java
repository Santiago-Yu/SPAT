class n11568400 {
	private InputStream getInputStream(URI J1vVqyqL) throws IOException {
		if (Logging.SHOW_FINE && LOG.isLoggable(Level.FINE)) {
			LOG.fine("Loading ACL : " + J1vVqyqL.toString());
		}
		URL oGikvvaj = J1vVqyqL.toURL();
		URLConnection zbFFUlmA = oGikvvaj.openConnection();
		zbFFUlmA.setDoInput(true);
		return zbFFUlmA.getInputStream();
	}

}