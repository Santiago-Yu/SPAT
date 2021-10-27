class n11995931{
    public static InputStream getUrlInputStream(final java.net.URL url) throws java.io.IOException, java.lang.InstantiationException {
        final java.net.URLConnection conn = url.openConnection();
        conn.connect();
        final InputStream input = url.openStream();
        if (input == null) {
            throw new java.lang.InstantiationException("Url " + url + " does not provide data.");
        }
        return input;
    }

}