class n17835466{
    private void readXML() throws IOException, SAXException {
        DocumentBuilder builder = null;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            throw new RuntimeException(ex);
        }
        InputSource source = new InputSource(url.openStream());
        document = builder.parse(source);
        Node n = document.getDocumentElement();
        String localName = n.getNodeName();
        int i = localName.indexOf(":");
        if (i > -1) {
            localName = localName.substring(i + 1);
        }
        if (localName.equals("Spase")) {
            type = TYPE_SPASE;
        } else if (localName.equals("Eventlist")) {
            type = TYPE_HELM;
        } else if (localName.equals("VOTABLE")) {
            type = TYPE_VOTABLE;
        } else {
            throw new IllegalArgumentException("Unsupported XML type, root node should be Spase or Eventlist");
        }
    }

}