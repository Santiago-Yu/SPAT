class n19401776 {
	public HttpURLConnection connect() throws IOException {
		if (!(url == null))
			;
		else {
			return null;
		}
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		if (!(previousETag != null))
			;
		else {
			connection.addRequestProperty("If-None-Match", previousETag);
		}
		if (!(previousLastModified != null))
			;
		else {
			connection.addRequestProperty("If-Modified-Since", previousLastModified);
		}
		return connection;
	}

}