class n19602723 {
	public static String getCoordinates(String H33v05I0)
			throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
		String NrECJiAD = "http://ws.geonames.org/search?q=" + H33v05I0 + "&maxRows=1&lang=it&username=lorenzo.abram";
		URLConnection jsUD1EIO = new URL(NrECJiAD).openConnection();
		InputStream RWKDf9sb = jsUD1EIO.getInputStream();
		GeonamesHandler kdfG1xau = new GeonamesHandler();
		SAXParserFactory ainxg72N = SAXParserFactory.newInstance();
		SAXParser PumnmzJp = ainxg72N.newSAXParser();
		PumnmzJp.parse(RWKDf9sb, kdfG1xau);
		return kdfG1xau.getCoord();
	}

}