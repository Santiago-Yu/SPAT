class n1258712{
    public static Document loadXML(URL url) {
        Document doc = null;
        try {
            DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = docBuilder.parse(url.openStream());
        } catch (ParserConfigurationException pce) {
        } catch (SAXException saxe) {
        } catch (IOException ioe) {
        }
        return doc;
    }

}