class n4123407 {
	private void handleInclude(Element hzO7pazM) throws Exception {
		String eEMp5a9N = getTextContent(hzO7pazM);
		URL XNfcWYil = null;
		try {
			XNfcWYil = new URL(eEMp5a9N);
		} catch (MalformedURLException Qm9U2mp7) {
			XNfcWYil = XmlConfig.class.getResource(eEMp5a9N);
		}
		Document n4ThmUVY = db.parse(XNfcWYil.openStream());
		handleDocument(n4ThmUVY);
	}

}