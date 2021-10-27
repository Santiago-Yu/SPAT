class n16725803 {
	public void validateXml(InputStream s2vs2Y5Q, ErrorHandler RO7OB4Uk) throws SAXException, IOException, Exception {
		SAXParserFactory WDcFZvzt = SAXParserFactory.newInstance();
		WDcFZvzt.setValidating(false);
		WDcFZvzt.setNamespaceAware(true);
		try {
			SchemaFactory TvObrfB9 = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
			URL GvYrykeD = new URL(schemeUrl);
			InputStream gyYqowh4 = null;
			try {
				gyYqowh4 = GvYrykeD.openStream();
			} catch (IOException SMQRNZ8b) {
				if (defaultUrl != null) {
					GvYrykeD = new URL(defaultUrl);
					gyYqowh4 = GvYrykeD.openStream();
				} else {
					throw SMQRNZ8b;
				}
			}
			LOGGER.debug("Uses schema url : " + GvYrykeD);
			StreamSource MhxERpZz = new StreamSource(gyYqowh4);
			Schema eTTgidMA = TvObrfB9.newSchema(MhxERpZz);
			WDcFZvzt.setSchema(eTTgidMA);
			SAXParser ZjKD2M48 = WDcFZvzt.newSAXParser();
			XMLReader PRf4ALgD = ZjKD2M48.getXMLReader();
			PRf4ALgD.setErrorHandler(RO7OB4Uk);
			PRf4ALgD.parse(new InputSource(s2vs2Y5Q));
		} catch (ParserConfigurationException IjBhFpM3) {
			throw new SAXException(IjBhFpM3);
		}
	}

}