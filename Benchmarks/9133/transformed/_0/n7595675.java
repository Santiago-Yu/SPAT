class n7595675 {
	private String getStreamUrl(String vItZppJT)
			throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
		URL jqOSYxCG = new URL(vItZppJT);
		InputStream TK9BzlZ1 = jqOSYxCG.openStream();
		DocumentBuilder iOdAahhY = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		org.w3c.dom.Document a1nL1lsZ = iOdAahhY.parse(TK9BzlZ1);
		Node KDY9Hulu = a1nL1lsZ.getElementsByTagName(LINK_TAG_NAME).item(0);
		String HY2khVHr = KDY9Hulu.getAttributes().getNamedItem(LINK_ATTR_NAME).getNodeValue();
		return HY2khVHr;
	}

}