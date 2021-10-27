    public void load(URL url) throws IOException {
        ResourceLocator locator = null;
        try {
            locator = new RelativeResourceLocator(url);
        } catch (URISyntaxException use) {
            throw new IllegalArgumentException("Bad URL: " + use);
        }
        ResourceLocatorTool.addResourceLocator(ResourceLocatorTool.TYPE_TEXTURE, locator);
        InputStream stream = null;
        try {
            stream = url.openStream();
            if (stream == null) {
                throw new IOException("Failed to load materials file '" + url + "'");
            }
            logger.fine("Loading materials from '" + url + "'...");
            load(stream);
        } finally {
            if (stream != null) stream.close();
            ResourceLocatorTool.removeResourceLocator(ResourceLocatorTool.TYPE_TEXTURE, locator);
            locator = null;
        }
    }
