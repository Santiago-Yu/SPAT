class n1258712 {
	public static Document loadXML(URL y4vaXgaf) {
		Document fjWgOkgN = null;
		try {
			DocumentBuilder lLZjsv1P = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			fjWgOkgN = lLZjsv1P.parse(y4vaXgaf.openStream());
		} catch (ParserConfigurationException E5Yih3zx) {
		} catch (SAXException a8uoZFnS) {
		} catch (IOException EyYCPd0e) {
		}
		return fjWgOkgN;
	}

}