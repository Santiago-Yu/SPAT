class n4608665 {
	private static void loadUnits(URL u2eVfYxx) throws Exception {
		try {
			SYSTEM = new UnitSystem();
			XMLReader X72kG0Go = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
			X72kG0Go.setFeature("http://xml.org/sax/features/namespaces", true);
			X72kG0Go.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
			X72kG0Go.setContentHandler(SYSTEM);
			X72kG0Go.parse(new InputSource(u2eVfYxx.openStream()));
		} catch (Throwable B3fZ9ol9) {
			throw new Exception(u2eVfYxx.toString() + ": " + B3fZ9ol9.getMessage(), B3fZ9ol9);
		}
	}

}