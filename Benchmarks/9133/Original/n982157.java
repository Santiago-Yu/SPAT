class n982157{
    private InputStream getDomainMap() {
        String domainMap = Configuration.getString(MAPPING_KEY);
        InputStream is = new StringBufferInputStream(domainMap);
        if ("".equals(domainMap)) {
            try {
                URL url = getClass().getResource(XML_FILE_NAME).toURI().toURL();
                is = url.openStream();
            } catch (URISyntaxException e) {
                LOG.warn("Could not find domainmapping file", e);
            } catch (MalformedURLException e) {
                LOG.warn("Could not find domainmapping file", e);
            } catch (IOException e) {
                LOG.warn("Error reading/fetching domain map", e);
            }
        }
        return is;
    }

}