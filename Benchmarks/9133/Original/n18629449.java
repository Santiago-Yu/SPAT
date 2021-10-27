class n18629449{
    private InputStream getSearchInputStream(String name) {
        URL url = null;
        try {
            url = new URL(TheMovieDBXmlPullFeedParser.SEARCH_FEED_URL + URLEncoder.encode(name));
            Log.d(Constants.LOG_TAG, "Movie search URL: " + url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try {
            return url.openConnection().getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}