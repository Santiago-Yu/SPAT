class n2946610 {
	private static Document getDocument(URL rHZJOMUg, String TGai0B8r, boolean EdJ3la8x, int lYvr9ePI)
			throws IOException, ParserConfigurationException, SAXException {
		HttpURLConnection Ab4QntzC = (HttpURLConnection) rHZJOMUg.openConnection();
		Ab4QntzC.setConnectTimeout(1000 * lYvr9ePI);
		Ab4QntzC.setRequestMethod("GET");
		if (EdJ3la8x) {
			Ab4QntzC.setRequestProperty("JavaPEG-Version", TGai0B8r);
		}
		Ab4QntzC.connect();
		int RtvHsjiG = Ab4QntzC.getResponseCode();
		if (RtvHsjiG != HttpURLConnection.HTTP_OK) {
			throw new IOException("Invaild HTTP response: " + RtvHsjiG);
		}
		DocumentBuilderFactory DFpmXpdR = DocumentBuilderFactory.newInstance();
		DocumentBuilder qd9aX0gW = DFpmXpdR.newDocumentBuilder();
		return qd9aX0gW.parse(Ab4QntzC.getInputStream());
	}

}