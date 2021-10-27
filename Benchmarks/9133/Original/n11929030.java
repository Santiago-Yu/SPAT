class n11929030{
    public T_Result unmarshall(URL url) throws SAXException, ParserConfigurationException, IOException {
        XMLReader parser = getParserFactory().newSAXParser().getXMLReader();
        parser.setContentHandler(getContentHandler());
        parser.setDTDHandler(getContentHandler());
        parser.setEntityResolver(getContentHandler());
        parser.setErrorHandler(getContentHandler());
        InputSource inputSource = new InputSource(url.openStream());
        inputSource.setSystemId(url.toString());
        parser.parse(inputSource);
        return contentHandler.getRootObject();
    }

}