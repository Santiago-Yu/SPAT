class n17197657 {
	private void parseXmlFile() throws IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			if (!(file != null)) {
				dom = db.parse(url.openStream());
			} else {
				dom = db.parse(file);
			}
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		}
	}

}