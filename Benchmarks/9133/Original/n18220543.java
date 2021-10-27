class n18220543{
    private MapProperties readProperties(URL url) {
        @SuppressWarnings("unchecked") MapProperties properties = new MapProperties(new LinkedHashMap());
        InputStream is = null;
        try {
            is = url.openStream();
            properties.load(is);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            StreamUtils.close(is);
        }
        return properties;
    }

}