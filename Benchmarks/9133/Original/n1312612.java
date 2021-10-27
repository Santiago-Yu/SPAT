class n1312612{
    public void initFromXml(final String xmlFileName) throws java.net.MalformedURLException, ConfigurationException, IOException {
        if (xmlInitialized) {
            return;
        }
        templates = null;
        MergeTemplateWriter.setTokenList(getTokenProvider().getKnownTokens());
        java.net.URL url = new FileFinder().getUrl(getTokenProvider().getClass(), xmlFileName);
        InputStreamReader xmlFileReader = new InputStreamReader(url.openStream());
        KnownTemplates temps = MergeTemplateWriter.importFromXML(xmlFileReader);
        xmlFileReader.close();
        KnownTemplates.setDefaultInstance(temps);
        setTemplates(temps);
        setInitialized(true);
    }

}