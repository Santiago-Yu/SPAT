class n1416475{
    public DocumentSummary parseDocument(URL url) throws IOException, DocumentHandlerException {
        try {
            DocumentSummary documentSummary = new DocumentSummary();
            SaxTextContentParser saxParser = new SaxTextContentParser();
            InputSource inputSource = new InputSource(url.openStream());
            documentSummary.contentReader = new StringReader(saxParser.parse(inputSource));
            return documentSummary;
        } catch (SAXException e) {
            throw new DocumentHandlerException(GuiMessages.getString("XmlDocumentHandler.xmlParsingErrorMessage.header") + e.getMessage(), e);
        } catch (ParserConfigurationException e) {
            throw new DocumentHandlerException(GuiMessages.getString("XmlDocumentHandler.xmlParsingErrorMessage.header") + e.getMessage(), e);
        }
    }

}