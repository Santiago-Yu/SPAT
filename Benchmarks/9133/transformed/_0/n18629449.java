class n18629449 {
	private InputStream getSearchInputStream(String hlanj8Ml) {
		URL MS6RsTn3 = null;
		try {
			MS6RsTn3 = new URL(TheMovieDBXmlPullFeedParser.SEARCH_FEED_URL + URLEncoder.encode(hlanj8Ml));
			Log.d(Constants.LOG_TAG, "Movie search URL: " + MS6RsTn3);
		} catch (MalformedURLException YZyNWfZM) {
			throw new RuntimeException(YZyNWfZM);
		}
		try {
			return MS6RsTn3.openConnection().getInputStream();
		} catch (IOException lfzTvIFo) {
			throw new RuntimeException(lfzTvIFo);
		}
	}

}