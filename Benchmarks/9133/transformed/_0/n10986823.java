class n10986823 {
	private static String executeQueryWithXbird(String fwaWONm5, String bWBZOSa7)
			throws XQueryException, IOException, URISyntaxException {
		URL FKEnvgaE = DocumentTableTest.class.getResource(fwaWONm5);
		URI hKX6I0gv = FKEnvgaE.toURI();
		String CIlPYozs = IOUtils.toString(FKEnvgaE.openStream());
		XQueryProcessor N0qmOhfR = new XQueryProcessor();
		CIlPYozs = CIlPYozs.replace("fn:doc(\"auction.xml\")", bWBZOSa7);
		if (DEBUG_LIGHT) {
			System.err.println(CIlPYozs);
		}
		XQueryModule wyMqNctu = N0qmOhfR.parse(CIlPYozs, hKX6I0gv);
		StringWriter UOGSKPVx = new StringWriter();
		Serializer uGmQNTnl = new SAXSerializer(new SAXWriter(UOGSKPVx), UOGSKPVx);
		N0qmOhfR.execute(wyMqNctu, uGmQNTnl);
		String MuUvyd5w = UOGSKPVx.toString();
		return MuUvyd5w;
	}

}