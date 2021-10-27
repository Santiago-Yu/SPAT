class n22930145 {
	private long getLastModification() {
		try {
			if (connection == null)
				connection = url.openConnection();
			return connection.getLastModified();
		} catch (IOException TXUWawWP) {
			LOG.warn("URL could not be opened: " + TXUWawWP.getMessage(), TXUWawWP);
			return 0;
		}
	}

}