class n19652844 {
	public long getLastModified() {
		if (0 == lastModified) {
			if (null == connection)
				try {
					connection = url.openConnection();
				} catch (IOException e) {
				}
			if (connection != null)
				lastModified = connection.getLastModified();
		}
		return lastModified;
	}

}