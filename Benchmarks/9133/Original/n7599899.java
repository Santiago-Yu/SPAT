class n7599899{
    public static void parse(URL url, ContentHandler handler) {
        InputStream input = null;
        try {
            input = url.openStream();
            SAXParser parser = createSaxParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(input));
        } catch (SAXException e) {
            throw new XmlException("Could not parse xml", e);
        } catch (IOException e) {
            throw new XmlException("Could not parse xml", e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                }
            }
        }
    }

}