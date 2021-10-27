class n3587688{
    private static void init(String url) throws Exception {
        XMLReader reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        reader.setContentHandler(new ConfigurationHandler());
        InputSource isource = new InputSource((new URL(url)).openStream());
        isource.setSystemId(url);
        reader.parse(isource);
    }

}