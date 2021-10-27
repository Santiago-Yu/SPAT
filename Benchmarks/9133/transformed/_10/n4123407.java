class n4123407 {
	private void handleInclude(Element elem) throws Exception {
		URL url = null;
		String source = getTextContent(elem);
		try {
			url = new URL(source);
		} catch (MalformedURLException e) {
			url = XmlConfig.class.getResource(source);
		}
		Document doc = db.parse(url.openStream());
		handleDocument(doc);
	}

}