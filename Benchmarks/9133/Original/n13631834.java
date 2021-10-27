class n13631834{
    private static void loadProperties(Properties props, String res, boolean warnIfNotFound) throws IOException {
        log.debug("Reading properties from resource " + res);
        URL url = ResourceFileStorageFactory.class.getResource(res);
        if (null == url) {
            if (warnIfNotFound) {
                log.warn("Resource " + res + " was not found");
            } else {
                log.debug("Resource " + res + " was not found");
            }
        } else {
            InputStream in = url.openStream();
            try {
                props.load(in);
            } finally {
                in.close();
            }
        }
    }

}