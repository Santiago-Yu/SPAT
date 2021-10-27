class n22484885{
    private void initClientConfigurationFromURL(String urlStr) throws Exception {
        try {
            URL url = ProxyURLFactory.createHttpUrl(urlStr);
            initClientConfiguration(url.openStream());
        } catch (Exception e) {
            throw new Exception("Could not initialize from Client Configuration URL:" + urlStr, e);
        }
    }

}