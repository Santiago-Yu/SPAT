class n3587688 {
	private static void init(String uW556vQB) throws Exception {
		XMLReader wQ6LVydL = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
		wQ6LVydL.setContentHandler(new ConfigurationHandler());
		InputSource VA1cXuKH = new InputSource((new URL(uW556vQB)).openStream());
		VA1cXuKH.setSystemId(uW556vQB);
		wQ6LVydL.parse(VA1cXuKH);
	}

}