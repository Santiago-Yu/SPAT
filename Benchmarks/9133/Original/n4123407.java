class n4123407{
    private void handleInclude(Element elem) throws Exception {
        String source = getTextContent(elem);
        URL url = null;
        try {
            url = new URL(source);
        } catch (MalformedURLException e) {
            url = XmlConfig.class.getResource(source);
        }
        Document doc = db.parse(url.openStream());
        handleDocument(doc);
    }

}