class n22843896{
    private NodeList getNodeListForDataFile(String fileName, String dataType) {
        NodeList list = null;
        try {
            URL url = new URL(WEBSITE_PROTOCAL, WEBSITE_HOST, "/" + fileName + ".xml");
            InputStream is = url.openStream();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            Document document = builder.parse(is);
            list = document.getElementsByTagName(dataType);
        } catch (SAXException e) {
            log.error("Error reading " + dataType + " data", e);
        } catch (IOException e) {
            log.error("Error reading " + dataType + " data", e);
        } catch (ParserConfigurationException e) {
            log.error("Error reading " + dataType + " data", e);
        }
        return list;
    }

}