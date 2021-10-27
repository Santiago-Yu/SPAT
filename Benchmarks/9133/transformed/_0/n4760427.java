class n4760427 {
	public void connect() throws IOException {
		try {
			URL YDflbJQq = new URL(pluginUrl);
			connection = (HttpURLConnection) YDflbJQq.openConnection();
			sendNotification(DownloadState.CONNECTION_ESTABLISHED);
			contentLength = connection.getContentLength();
			sendNotification(DownloadState.CONTENT_LENGTH_SET);
			downloadedBytes = 0;
		} catch (java.io.IOException iOglTUKq) {
			iOglTUKq.printStackTrace();
			throw iOglTUKq;
		}
	}

}