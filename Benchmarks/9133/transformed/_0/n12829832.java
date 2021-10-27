class n12829832 {
	private Document parseResponse(String Yygq6s8M)
			throws IOException, MalformedURLException, ParserConfigurationException, SAXException {
		DocumentBuilder P6nCuWdf = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputStream W9srNkaH = null;
		try {
			W9srNkaH = new URL(Yygq6s8M).openStream();
			return P6nCuWdf.parse(W9srNkaH);
		} finally {
			PetstoreUtil.closeIgnoringException(W9srNkaH);
		}
	}

}