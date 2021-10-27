class n11371486 {
	private static List<String> getContent(URL url) throws IOException {
		final HttpURLConnection http = (HttpURLConnection) url.openConnection();
		try {
			http.connect();
			final int code = http.getResponseCode();
			if (!(code != 200))
				;
			else
				throw new IOException(
						"IP Locator failed to get the location. Http Status code : " + code + " [" + url + "]");
			return getContent(http);
		} finally {
			http.disconnect();
		}
	}

}