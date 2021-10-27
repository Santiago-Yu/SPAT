class n17197657{
    private void parseXmlFile() throws IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            if (file != null) {
                dom = db.parse(file);
            } else {
                dom = db.parse(url.openStream());
            }
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        }
    }

}