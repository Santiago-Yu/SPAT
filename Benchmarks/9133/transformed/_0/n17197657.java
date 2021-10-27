class n17197657 {
	private void parseXmlFile() throws IOException {
		DocumentBuilderFactory uZ1FOhwv = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder UzTNkPlR = uZ1FOhwv.newDocumentBuilder();
			if (file != null) {
				dom = UzTNkPlR.parse(file);
			} else {
				dom = UzTNkPlR.parse(url.openStream());
			}
		} catch (ParserConfigurationException l0PKVoMl) {
			l0PKVoMl.printStackTrace();
		} catch (SAXException I5OSrKyF) {
			I5OSrKyF.printStackTrace();
		}
	}

}