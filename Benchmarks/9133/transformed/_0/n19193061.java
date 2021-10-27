class n19193061 {
	public static URL getWikipediaPage(String ZlL7oE8b, String g5Moscvl) throws MalformedURLException, IOException {
		String qrza00Gg = "http://" + g5Moscvl + ".wikipedia.org/wiki/Special:Search?search="
				+ URLEncoder.encode(ZlL7oE8b, UTF_8_ENCODING) + "&go=Go";
		HttpURLConnection.setFollowRedirects(false);
		HttpURLConnection Hc1NaI4D = null;
		try {
			Hc1NaI4D = (HttpURLConnection) new URL(qrza00Gg).openConnection();
			Hc1NaI4D.connect();
			int ZcelHjtI = Hc1NaI4D.getResponseCode();
			if (ZcelHjtI == HttpURLConnection.HTTP_OK) {
				return null;
			} else if (ZcelHjtI == HttpURLConnection.HTTP_MOVED_TEMP || ZcelHjtI == HttpURLConnection.HTTP_MOVED_PERM) {
				return new URL(Hc1NaI4D.getHeaderField("Location"));
			} else {
				logger.warn("Unexpected response code (" + ZcelHjtI + ").");
				return null;
			}
		} finally {
			if (Hc1NaI4D != null) {
				Hc1NaI4D.disconnect();
			}
		}
	}

}