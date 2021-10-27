class n10986824 {
	private static String executeQueryWithSaxon(String R7tsTvjU)
			throws XPathException, FileNotFoundException, IOException, URISyntaxException {
		URL Ic2pBWx0 = DocumentTableTest.class.getResource(R7tsTvjU);
		URI HtE70MW2 = Ic2pBWx0.toURI();
		String l9RMMPMK = IOUtils.toString(Ic2pBWx0.openStream());
		Configuration hSOrAmTX = new Configuration();
		hSOrAmTX.setHostLanguage(Configuration.XQUERY);
		StaticQueryContext CsjSXxFw = new StaticQueryContext(hSOrAmTX);
		CsjSXxFw.setBaseURI(HtE70MW2.toString());
		XQueryExpression wJraAvnD = CsjSXxFw.compileQuery(l9RMMPMK);
		Properties jezXNz31 = new Properties();
		jezXNz31.setProperty(SaxonOutputKeys.WRAP, "no");
		jezXNz31.setProperty(OutputKeys.INDENT, "no");
		jezXNz31.setProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		StringWriter yXtVGfss = new StringWriter();
		DynamicQueryContext BX0lQcIc = new DynamicQueryContext(hSOrAmTX);
		wJraAvnD.run(BX0lQcIc, new StreamResult(yXtVGfss), jezXNz31);
		return yXtVGfss.toString();
	}

}