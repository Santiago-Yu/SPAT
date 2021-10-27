class n10242903{
    private List<Feature> getFeatures(String source, EntryPoint e) throws MalformedURLException, SAXException, IOException, ParserConfigurationException, URISyntaxException {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        FeatureParser featp = new FeatureParser();
        parser.parse(URIFactory.url(serverPrefix + "/das/" + source + "/features?segment=" + e.id + ":" + e.start + "," + e.stop).openStream(), featp);
        return featp.list;
    }

}