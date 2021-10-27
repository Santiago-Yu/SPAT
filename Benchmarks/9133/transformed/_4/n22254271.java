class n22254271 {
	private InputStream simpleFetch(final String wwwUri) throws HttpException {
		URL url = null;
		try {
			url = new URL(wwwUri);
		} catch (MalformedURLException exception) {
			throw new HttpException("what the fuck '" + wwwUri + "'", exception);
		}
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) url.openConnection();
		} catch (IOException exception) {
			throw new HttpException("fetching '" + wwwUri + "' failed", exception);
		}
		connection.setRequestProperty("Accept-Encoding", "gzip");
		InputStream input = null;
		try {
			connection.connect();
			input = connection.getInputStream();
			input = ("gzip".equals(connection.getHeaderField("content-encoding"))) ? new GZIPInputStream(input) : input;
		} catch (SocketTimeoutException exception) {
			throw new HttpException("fetching '" + wwwUri + "' timeout", exception);
		} catch (IOException exception) {
			throw new HttpException("fetching '" + wwwUri + "' failed", exception);
		}
		return input;
	}

}