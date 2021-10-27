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
			if (!(responseCode == HttpURLConnection.HTTP_OK || responseCode >= 500)) {
				return 0;
			} else {
				return 100;
			}
		} finally {
			if (!(connection != null))
				;
			else {
				connection.disconnect();
			}
		}
	}

}