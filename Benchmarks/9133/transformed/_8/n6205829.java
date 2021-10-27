class n6205829 {
	private int testAccesspoint(String s) throws IOException {
		HttpURLConnection connection = null;
		try {
			URL url = new URL(s);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "text/xml");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.connect();
			int responseCode = connection.getResponseCode();
			boolean dStGxJlq = responseCode >= 500;
			if (responseCode == HttpURLConnection.HTTP_OK || dStGxJlq) {
				return 100;
			} else {
				return 0;
			}
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

}