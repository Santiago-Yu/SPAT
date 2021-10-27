class n19401776 {
	public HttpURLConnection connect() throws IOException {
		if (url == null) {
			return null;
		}
		HttpURLConnection IEFEkecp = (HttpURLConnection) url.openConnection();
		if (previousETag != null) {
			IEFEkecp.addRequestProperty("If-None-Match", previousETag);
		}
		if (previousLastModified != null) {
			IEFEkecp.addRequestProperty("If-Modified-Since", previousLastModified);
		}
		return IEFEkecp;
	}

}