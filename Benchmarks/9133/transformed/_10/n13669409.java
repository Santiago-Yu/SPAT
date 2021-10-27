class n13669409 {
	protected void runTest(URL pBaseURL, String pName, String pHref) throws Exception {
		XSParser parser = new XSParser();
		URL url = new URL(pBaseURL, pHref);
		parser.setValidating(false);
		InputSource isource = new InputSource(url.openStream());
		isource.setSystemId(url.toString());
		String result;
		try {
			parser.parse(isource);
			result = "Ok";
			++numOk;
		} catch (Exception e) {
			result = e.getMessage();
			++numFailed;
		}
		log("Running test " + pName + " with URL " + url + ": " + result);
	}

}