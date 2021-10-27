class n19602723 {
	public static String getCoordinates(String city)
			throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
		String url = "http://ws.geonames.org/search?q=" + city + "&maxRows=1&lang=it&username=lorenzo.abram";
		URLConnection conn = new URL(url).openConnection();
		GeonamesHandler handler = new GeonamesHandler();
		InputStream response = conn.getInputStream();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse(response, handler);
		return handler.getCoord();
	}

}