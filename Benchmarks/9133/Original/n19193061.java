class n19193061{
    public static URL getWikipediaPage(String concept, String language) throws MalformedURLException, IOException {
        String url = "http://" + language + ".wikipedia.org/wiki/Special:Search?search=" + URLEncoder.encode(concept, UTF_8_ENCODING) + "&go=Go";
        HttpURLConnection.setFollowRedirects(false);
        HttpURLConnection httpConnection = null;
        try {
            httpConnection = (HttpURLConnection) new URL(url).openConnection();
            httpConnection.connect();
            int responseCode = httpConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return null;
            } else if (responseCode == HttpURLConnection.HTTP_MOVED_TEMP || responseCode == HttpURLConnection.HTTP_MOVED_PERM) {
                return new URL(httpConnection.getHeaderField("Location"));
            } else {
                logger.warn("Unexpected response code (" + responseCode + ").");
                return null;
            }
        } finally {
            if (httpConnection != null) {
                httpConnection.disconnect();
            }
        }
    }

}