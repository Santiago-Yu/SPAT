class n17835466 {
	private void readXML() throws IOException, SAXException {
		DocumentBuilder I6uEmzkR = null;
		try {
			I6uEmzkR = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException xFpWjJSq) {
			throw new RuntimeException(xFpWjJSq);
		}
		InputSource ffz2lL1A = new InputSource(url.openStream());
		document = I6uEmzkR.parse(ffz2lL1A);
		Node Jmd2pyHi = document.getDocumentElement();
		String uPmYrEF3 = Jmd2pyHi.getNodeName();
		int rariXO33 = uPmYrEF3.indexOf(":");
		if (rariXO33 > -1) {
			uPmYrEF3 = uPmYrEF3.substring(rariXO33 + 1);
		}
		if (uPmYrEF3.equals("Spase")) {
			type = TYPE_SPASE;
		} else if (uPmYrEF3.equals("Eventlist")) {
			type = TYPE_HELM;
		} else if (uPmYrEF3.equals("VOTABLE")) {
			type = TYPE_VOTABLE;
		} else {
			throw new IllegalArgumentException("Unsupported XML type, root node should be Spase or Eventlist");
		}
	}

}