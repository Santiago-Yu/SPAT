class n20741835 {
	@Override
	public Response executeGet(String url) throws IOException {
		if (logger.isLoggable(INFO))
			logger.info("Making a GET request to " + url);
		HttpURLConnection httpUrlConnection = null;
		InputStream inputStream = null;
		try {
			httpUrlConnection = openConnection(new URL(url));
			httpUrlConnection.setReadTimeout(DEFAULT_READ_TIMEOUT_IN_MS);
			httpUrlConnection.setUseCaches(false);
			customizeConnection(httpUrlConnection);
			httpUrlConnection.setRequestMethod("GET");
			httpUrlConnection.connect();
			if (logger.isLoggable(FINER))
				logger.finer("Response headers: " + httpUrlConnection.getHeaderFields());
			try {
				if (httpUrlConnection.getResponseCode() != HTTP_OK)
					inputStream = httpUrlConnection.getErrorStream();
				else
					inputStream = httpUrlConnection.getInputStream();
			} catch (IOException e) {
				if (logger.isLoggable(WARNING))
					logger.warning("An error occurred while making a GET request to " + url + ": " + e);
			}
			return new Response(httpUrlConnection.getResponseCode(), fromInputStream(inputStream));
		} finally {
			closeQuietly(httpUrlConnection);
		}
	}

}