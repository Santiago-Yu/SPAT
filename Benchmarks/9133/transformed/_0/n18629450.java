class n18629450 {
	private InputStream getInfoInputStream(String tV7Lnu8M) {
		URL Zbhy0NIt = null;
		try {
			Zbhy0NIt = new URL(TheMovieDBXmlPullFeedParser.INFO_FEED_URL + URLEncoder.encode(tV7Lnu8M));
			Log.d(Constants.LOG_TAG, "Movie info URL: " + Zbhy0NIt);
		} catch (MalformedURLException XfJC07wX) {
			throw new RuntimeException(XfJC07wX);
		}
		try {
			return Zbhy0NIt.openConnection().getInputStream();
		} catch (IOException FxhvbpVe) {
			throw new RuntimeException(FxhvbpVe);
		}
	}

}