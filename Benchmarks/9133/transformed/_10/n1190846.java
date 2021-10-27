class n1190846 {
	private HttpURLConnection connect() throws MalformedURLException, IOException {
		if (repositoryLocation == null) {
			Utils.debug("RemoteRepository", "repository Location unspecified");
			return null;
		}
		HttpURLConnection connection = null;
		URL url = new URL(repositoryLocation);
		connection = (HttpURLConnection) url.openConnection();
		return connection;
	}

}