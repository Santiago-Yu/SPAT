class n13669410{
    protected void runTests(URL pBaseURL, String pName, String pHref) throws Exception {
        URL url = new URL(pBaseURL, pHref);
        InputSource isource = new InputSource(url.openStream());
        isource.setSystemId(url.toString());
        Document document = getDocumentBuilder().parse(isource);
        NodeList schemas = document.getElementsByTagNameNS(null, "Schema");
        for (int i = 0; i < schemas.getLength(); i++) {
            Element schema = (Element) schemas.item(i);
            runTest(url, schema.getAttribute("name"), schema.getAttribute("href"));
        }
    }

}