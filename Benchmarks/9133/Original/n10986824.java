class n10986824{
    private static String executeQueryWithSaxon(String queryFile) throws XPathException, FileNotFoundException, IOException, URISyntaxException {
        URL url = DocumentTableTest.class.getResource(queryFile);
        URI uri = url.toURI();
        String query = IOUtils.toString(url.openStream());
        Configuration config = new Configuration();
        config.setHostLanguage(Configuration.XQUERY);
        StaticQueryContext staticContext = new StaticQueryContext(config);
        staticContext.setBaseURI(uri.toString());
        XQueryExpression exp = staticContext.compileQuery(query);
        Properties props = new Properties();
        props.setProperty(SaxonOutputKeys.WRAP, "no");
        props.setProperty(OutputKeys.INDENT, "no");
        props.setProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter res_sw = new StringWriter();
        DynamicQueryContext dynamicContext = new DynamicQueryContext(config);
        exp.run(dynamicContext, new StreamResult(res_sw), props);
        return res_sw.toString();
    }

}