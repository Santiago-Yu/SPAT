class n613085 {
	private Document getDocument(URL muxkfGOg) throws SAXException, IOException {
		InputStream BCG7btkH;
		try {
			BCG7btkH = muxkfGOg.openStream();
		} catch (IOException gwmP5v5D) {
			System.out.println("parameter error : The specified reading data is mistaken.");
			System.out.println(" Request URL is " + sourceUri);
			throw new IOException("\t" + gwmP5v5D.toString());
		}
		DocumentBuilderFactory BKeb5qkl = DocumentBuilderFactory.newInstance();
		DocumentBuilder iPLeZZ6x = null;
		try {
			iPLeZZ6x = BKeb5qkl.newDocumentBuilder();
		} catch (ParserConfigurationException sJv2lnfk) {
			System.out.println("error : The error of DocumentBuilder instance generation");
			throw new RuntimeException(sJv2lnfk.toString());
		}
		Document HXQyuTBO;
		try {
			HXQyuTBO = iPLeZZ6x.parse(BCG7btkH);
		} catch (Exception g9iNpkEl) {
			System.out.println("error : parse of reading data went wrong.");
			System.out.println(" Request URL is " + sourceUri);
			throw new RuntimeException(g9iNpkEl.toString());
		}
		return HXQyuTBO;
	}

}