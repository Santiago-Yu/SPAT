class n8167130{
    public static final InputStream getConfigStream(final String path) {
        final URL url = ConfigHelper.locateConfig(path);
        if (url == null) {
            String msg = "Unable to locate config file: " + path;
            log.error(msg);
            return null;
        }
        try {
            return url.openStream();
        } catch (IOException e) {
            log.error("Unable to open config file: " + path, e);
        }
        return null;
    }

}