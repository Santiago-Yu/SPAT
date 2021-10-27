class n10986823{
    private static String executeQueryWithXbird(String queryFile, String replace) throws XQueryException, IOException, URISyntaxException {
        URL url = DocumentTableTest.class.getResource(queryFile);
        URI uri = url.toURI();
        String query = IOUtils.toString(url.openStream());
        XQueryProcessor processor = new XQueryProcessor();
        query = query.replace("fn:doc(\"auction.xml\")", replace);
        if (DEBUG_LIGHT) {
            System.err.println(query);
        }
        XQueryModule mod = processor.parse(query, uri);
        StringWriter res_sw = new StringWriter();
        Serializer ser = new SAXSerializer(new SAXWriter(res_sw), res_sw);
        processor.execute(mod, ser);
        String result = res_sw.toString();
        return result;
    }

}