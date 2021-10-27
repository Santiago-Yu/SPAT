class n11929030 {
	public T_Result unmarshall(URL qqgXJLy0) throws SAXException, ParserConfigurationException, IOException {
		XMLReader VxRDEo16 = getParserFactory().newSAXParser().getXMLReader();
		VxRDEo16.setContentHandler(getContentHandler());
		VxRDEo16.setDTDHandler(getContentHandler());
		VxRDEo16.setEntityResolver(getContentHandler());
		VxRDEo16.setErrorHandler(getContentHandler());
		InputSource M41mQGiS = new InputSource(qqgXJLy0.openStream());
		M41mQGiS.setSystemId(qqgXJLy0.toString());
		VxRDEo16.parse(M41mQGiS);
		return contentHandler.getRootObject();
	}

}