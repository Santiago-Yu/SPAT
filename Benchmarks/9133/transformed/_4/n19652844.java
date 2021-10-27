class n19652844 {
	public long getLastModified() {
		if (lastModified == 0) {
			if (connection == null)
				try {
					connection = url.openConnection();
				} catch (IOException e) {
				}
			lastModified = (connection != null) ? connection.getLastModified() : lastModified;
		}
		return lastModified;
	}

}