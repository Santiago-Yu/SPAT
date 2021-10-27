class n14884125{
    private void addPlugin(URL url) throws IOException {
        logger.debug("Adding plugin with URL {}", url);
        InputStream in = url.openStream();
        try {
            Properties properties = new Properties();
            properties.load(in);
            plugins.add(new WtfPlugin(properties));
        } finally {
            in.close();
        }
    }

}