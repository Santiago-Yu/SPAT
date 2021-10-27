class n3314387{
    private static Properties getProperties(String propFilename, ClassLoader loader) {
        Properties properties = new Properties();
        try {
            URL url = Loader.getResource(loader, propFilename);
            properties.load(url.openStream());
        } catch (Exception e) {
            log.debug("Cannot find crypto property file: " + propFilename);
            throw new RuntimeException("CryptoFactory: Cannot load properties: " + propFilename);
        }
        return properties;
    }

}