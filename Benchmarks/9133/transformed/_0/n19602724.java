class n19602724 {
	public static String getWikiPage(String eRZi4H6e)
			throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
		String eTA1WqS0 = "http://api.geonames.org/wikipediaSearch?q=" + eRZi4H6e
				+ "&maxRows=1&lang=it&username=lorenzo.abram";
		URLConnection deO0VZl4 = new URL(eTA1WqS0).openConnection();
		InputStream cDStszwu = deO0VZl4.getInputStream();
		GeonamesHandler GIIVJhnh = new GeonamesHandler();
		SAXParserFactory o6g8FPE4 = SAXParserFactory.newInstance();
		SAXParser CeT4HTiO = o6g8FPE4.newSAXParser();
		CeT4HTiO.parse(cDStszwu, GIIVJhnh);
		return GIIVJhnh.getUrl();
	}

}