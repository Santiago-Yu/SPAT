class n9827345{
    private static Properties getProperties(String propFilename) {
        Properties properties = new Properties();
        try {
            URL url = Loader.getResource(propFilename);
            properties.load(url.openStream());
        } catch (Exception e) {
            log.debug("Cannot find SAML property file: " + propFilename);
            throw new RuntimeException("SAMLIssuerFactory: Cannot load properties: " + propFilename);
        }
        return properties;
    }

}