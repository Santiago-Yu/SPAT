class n12829832 {
	private Document parseResponse(String url)
			throws IOException, MalformedURLException, ParserConfigurationException, SAXException {
		InputStream stream = null;
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		try {
			stream = new URL(url).openStream();
			return db.parse(stream);
		} finally {
			PetstoreUtil.closeIgnoringException(stream);
		}
	}

}