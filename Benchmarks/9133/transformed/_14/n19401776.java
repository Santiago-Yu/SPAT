class n19401776 {
	public HttpURLConnection connect() throws IOException {
		if (null == url) {
			return null;
		}
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		if (previousETag != null) {
			connection.addRequestProperty("If-None-Match", previousETag);
		}
		if (previousLastModified != null) {
			connection.addRequestProperty("If-Modified-Since", previousLastModified);
		}
		return connection;
	}

}