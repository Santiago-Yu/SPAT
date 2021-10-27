class n8833167{
    @SuppressWarnings("unchecked")
    private final D loadMeta(URL url) throws IOException {
        SAXParser saxParser;
        try {
            saxParser = SAX_PARSER_FACTORY.newSAXParser();
        } catch (ParserConfigurationException e) {
            throw new Error(e);
        } catch (SAXException e) {
            throw new Error(e);
        }
        try {
            saxParser.setProperty("http://xml.org/sax/features/validation", false);
        } catch (SAXNotRecognizedException e) {
            e.printStackTrace();
        } catch (SAXNotSupportedException e) {
            e.printStackTrace();
        }
        MetaParser handler = new MetaParser();
        try {
            saxParser.parse(url.openStream(), handler);
        } catch (SAXException e) {
            throw new ParsingException(e);
        }
        return ((D) handler.getMetaData());
    }

}