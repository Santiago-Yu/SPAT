class n5837430{
    public Configuration load(URL url) throws ConfigurationException {
        LOG.info("Configuring from url : " + url.toString());
        try {
            return load(url.openStream(), url.toString());
        } catch (IOException ioe) {
            throw new ConfigurationException("Could not configure from URL : " + url, ioe);
        }
    }

}