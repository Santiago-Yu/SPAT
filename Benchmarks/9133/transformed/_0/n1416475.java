class n1416475 {
	public DocumentSummary parseDocument(URL CaTgtncu) throws IOException, DocumentHandlerException {
		try {
			DocumentSummary fHxo7tBJ = new DocumentSummary();
			SaxTextContentParser z7AM8Z3U = new SaxTextContentParser();
			InputSource Y6kGJUPQ = new InputSource(CaTgtncu.openStream());
			fHxo7tBJ.contentReader = new StringReader(z7AM8Z3U.parse(Y6kGJUPQ));
			return fHxo7tBJ;
		} catch (SAXException uVdsgbk4) {
			throw new DocumentHandlerException(
					GuiMessages.getString("XmlDocumentHandler.xmlParsingErrorMessage.header") + uVdsgbk4.getMessage(),
					uVdsgbk4);
		} catch (ParserConfigurationException YcX6OpWx) {
			throw new DocumentHandlerException(
					GuiMessages.getString("XmlDocumentHandler.xmlParsingErrorMessage.header") + YcX6OpWx.getMessage(),
					YcX6OpWx);
		}
	}

}