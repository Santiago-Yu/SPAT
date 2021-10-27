class n14883984 {
	private Document parseResponse(String xQvEglc0)
			throws IOException, MalformedURLException, ParserConfigurationException, SAXException {
		DocumentBuilder vRjlsNwt = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputStream AX3K8Rpz = null;
		try {
			AX3K8Rpz = new URL(xQvEglc0).openStream();
			return vRjlsNwt.parse(AX3K8Rpz);
		} finally {
			if (AX3K8Rpz != null)
				AX3K8Rpz.close();
		}
	}

}