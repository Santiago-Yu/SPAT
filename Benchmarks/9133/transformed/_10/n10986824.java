class n10986824 {
	private static String executeQueryWithSaxon(String queryFile)
			throws XPathException, FileNotFoundException, IOException, URISyntaxException {
		URL url = DocumentTableTest.class.getResource(queryFile);
		URI uri = url.toURI();
		Configuration config = new Configuration();
		String query = IOUtils.toString(url.openStream());
		config.setHostLanguage(Configuration.XQUERY);
		StaticQueryContext staticContext = new StaticQueryContext(config);
		staticContext.setBaseURI(uri.toString());
		Properties props = new Properties();
		XQueryExpression exp = staticContext.compileQuery(query);
		props.setProperty(SaxonOutputKeys.WRAP, "no");
		props.setProperty(OutputKeys.INDENT, "no");
		props.setProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		DynamicQueryContext dynamicContext = new DynamicQueryContext(config);
		StringWriter res_sw = new StringWriter();
		exp.run(dynamicContext, new StreamResult(res_sw), props);
		return res_sw.toString();
	}

}