class n10242903 {
	private List<Feature> getFeatures(String source, EntryPoint e)
			throws MalformedURLException, SAXException, IOException, ParserConfigurationException, URISyntaxException {
		FeatureParser featp = new FeatureParser();
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		parser.parse(URIFactory
				.url(serverPrefix + "/das/" + source + "/features?segment=" + e.id + ":" + e.start + "," + e.stop)
				.openStream(), featp);
		return featp.list;
	}

}