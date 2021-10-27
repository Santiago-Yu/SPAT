class n11568400{
    private InputStream getInputStream(URI uri) throws IOException {
        if (Logging.SHOW_FINE && LOG.isLoggable(Level.FINE)) {
            LOG.fine("Loading ACL : " + uri.toString());
        }
        URL url = uri.toURL();
        URLConnection connection = url.openConnection();
        connection.setDoInput(true);
        return connection.getInputStream();
    }

}