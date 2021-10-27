class n10242903 {
	private List<Feature> getFeatures(String WmPHe8rw, EntryPoint utKqLwyY)
			throws MalformedURLException, SAXException, IOException, ParserConfigurationException, URISyntaxException {
		SAXParser rzBJlHve = SAXParserFactory.newInstance().newSAXParser();
		FeatureParser qNv8kR9h = new FeatureParser();
		rzBJlHve.parse(URIFactory.url(serverPrefix + "/das/" + WmPHe8rw + "/features?segment=" + utKqLwyY.id + ":"
				+ utKqLwyY.start + "," + utKqLwyY.stop).openStream(), qNv8kR9h);
		return qNv8kR9h.list;
	}

}