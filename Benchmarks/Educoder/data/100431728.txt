    protected static InputStream loadResource(String resource) throws MissingResourceException {
        Thread thread = Thread.currentThread();
        ClassLoader cLoader = thread.getContextClassLoader();
        URL url = cLoader.getResource(resource);
        if (url == null) {
            throw new MissingResourceException("Unable to find resource '" + resource + "'.", resource, resource);
        }
        try {
            InputStream is = url.openStream();
            return is;
        } catch (IOException e) {
            throw new MissingResourceException("Unable to load resource '" + resource + "' (IOException).", resource, resource);
        }
    }
