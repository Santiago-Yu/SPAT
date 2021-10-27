class n7595675{
    private String getStreamUrl(String adress) throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
        URL url = new URL(adress);
        InputStream is = url.openStream();
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        org.w3c.dom.Document doc = builder.parse(is);
        Node linkTag = doc.getElementsByTagName(LINK_TAG_NAME).item(0);
        String StreamUrl = linkTag.getAttributes().getNamedItem(LINK_ATTR_NAME).getNodeValue();
        return StreamUrl;
    }

}