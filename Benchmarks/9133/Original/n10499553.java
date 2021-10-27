class n10499553{
    private static InputStream connect(final String url) throws IOException {
        InputStream in = null;
        try {
            final URLConnection conn = new URL(url).openConnection();
            conn.setConnectTimeout(YahooGeocoding.connectTimeOut);
            conn.setReadTimeout(YahooGeocoding.readTimeOut);
            conn.setRequestProperty("User-Agent", YahooGeocoding.USER_AGENT);
            in = conn.getInputStream();
            return in;
        } catch (final IOException e) {
            Util.d("problems connecting to geonames url " + url + "Exception:" + e);
        }
        return in;
    }

}