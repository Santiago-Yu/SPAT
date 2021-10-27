class n12829832{
    private Document parseResponse(String url) throws IOException, MalformedURLException, ParserConfigurationException, SAXException {
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputStream stream = null;
        try {
            stream = new URL(url).openStream();
            return db.parse(stream);
        } finally {
            PetstoreUtil.closeIgnoringException(stream);
        }
    }

}