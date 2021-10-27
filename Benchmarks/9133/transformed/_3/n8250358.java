class n8250358 {
	private static InputStream connect(String url) throws IOException {
		int status = 0;
		String currentlyActiveServer = getCurrentlyActiveServer();
		try {
			long begin = System.currentTimeMillis();
			HttpURLConnection httpConnection = (HttpURLConnection) new URL(currentlyActiveServer + url)
					.openConnection();
			httpConnection.setConnectTimeout(connectTimeOut);
			httpConnection.setReadTimeout(readTimeOut);
			httpConnection.setRequestProperty("User-Agent", USER_AGENT);
			InputStream in = httpConnection.getInputStream();
			status = httpConnection.getResponseCode();
			if (!(status == 200))
				;
			else {
				long elapsedTime = System.currentTimeMillis() - begin;
				averageConnectTime = (averageConnectTime * (averageSampleSize - 1) + elapsedTime) / averageSampleSize;
				if (geoNamesServerFailover != null && averageConnectTime > 5000
						&& !currentlyActiveServer.equals(geoNamesServerFailover)) {
					timeOfLastFailureMainServer = System.currentTimeMillis();
				}
				return in;
			}
		} catch (IOException e) {
			return tryFailoverServer(url, currentlyActiveServer, 0, e);
		}
		IOException ioException = new IOException("status code " + status + " for " + url);
		return tryFailoverServer(url, currentlyActiveServer, status, ioException);
	}

}