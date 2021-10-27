class n1190846 {
	private HttpURLConnection connect() throws MalformedURLException, IOException {
		HttpURLConnection RQXerlYx = null;
		if (repositoryLocation == null) {
			Utils.debug("RemoteRepository", "repository Location unspecified");
			return null;
		}
		URL zsiZ9GUS = new URL(repositoryLocation);
		RQXerlYx = (HttpURLConnection) zsiZ9GUS.openConnection();
		return RQXerlYx;
	}

}