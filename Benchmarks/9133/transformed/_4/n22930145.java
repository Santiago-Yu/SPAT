class n22930145 {
	private long getLastModification() {
		try {
			connection = (connection == null) ? url.openConnection() : connection;
			return connection.getLastModified();
		} catch (IOException e) {
			LOG.warn("URL could not be opened: " + e.getMessage(), e);
			return 0;
		}
	}

}