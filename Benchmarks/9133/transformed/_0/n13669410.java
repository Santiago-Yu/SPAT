class n13669410 {
	protected void runTests(URL BTqTQhvn, String z6ygBy8s, String RqXv1JwU) throws Exception {
		URL M6KocV5r = new URL(BTqTQhvn, RqXv1JwU);
		InputSource fBzutctj = new InputSource(M6KocV5r.openStream());
		fBzutctj.setSystemId(M6KocV5r.toString());
		Document sIzpXW7u = getDocumentBuilder().parse(fBzutctj);
		NodeList xbV24wpZ = sIzpXW7u.getElementsByTagNameNS(null, "Schema");
		for (int r85zWF4X = 0; r85zWF4X < xbV24wpZ.getLength(); r85zWF4X++) {
			Element ESfwO1ol = (Element) xbV24wpZ.item(r85zWF4X);
			runTest(M6KocV5r, ESfwO1ol.getAttribute("name"), ESfwO1ol.getAttribute("href"));
		}
	}

}