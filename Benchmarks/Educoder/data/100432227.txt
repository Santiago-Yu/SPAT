    public InputStream loadResource(String location) throws GenericConfigException {
        URL url = getURL(location);
        try {
            return url.openStream();
        } catch (java.io.IOException e) {
            throw new GenericConfigException("Error opening URL resource at location [" + url.toExternalForm() + "]", e);
        }
    }
