class n21295980{
    protected URLConnection openURLConnection() throws IOException {
        final String locator = getMediaLocator();
        if (locator == null) {
            return null;
        }
        final URL url;
        try {
            url = new URL(locator);
        } catch (MalformedURLException ex) {
            throw new IllegalArgumentException(ex);
        }
        final URLConnection connection = url.openConnection();
        connection.connect();
        return connection;
    }

}