class n15364153{
    private void storeConfigurationPropertiesFile(java.net.URL url, String comp) {
        java.util.Properties p;
        try {
            p = new java.util.Properties();
            p.load(url.openStream());
        } catch (java.io.IOException ie) {
            System.err.println("error opening: " + url.getPath() + ": " + ie.getMessage());
            return;
        }
        storeConfiguration(p, comp);
        return;
    }

}