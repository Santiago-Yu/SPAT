class n4608665{
    private static void loadUnits(URL url) throws Exception {
        try {
            SYSTEM = new UnitSystem();
            XMLReader reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
            reader.setContentHandler(SYSTEM);
            reader.parse(new InputSource(url.openStream()));
        } catch (Throwable ex) {
            throw new Exception(url.toString() + ": " + ex.getMessage(), ex);
        }
    }

}