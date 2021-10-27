class n19058139 {
	public void init(final javax.swing.text.Document doc) {
		String dtdLocation = null;
		this.doc = doc;
		SyntaxDocument mDoc = (SyntaxDocument) doc;
		String schemaLocation = null;
		Object mDtd = mDoc.getProperty(XPontusConstantsIF.PARSER_DATA_DTD_COMPLETION_INFO);
		if (mDtd != null) {
			dtdLocation = mDtd.toString();
		}
		Object mXsd = mDoc.getProperty(XPontusConstantsIF.PARSER_DATA_SCHEMA_COMPLETION_INFO);
		Object o = doc.getProperty("BUILTIN_COMPLETION");
		if (mXsd != null) {
			schemaLocation = mXsd.toString();
		}
		if (o != null) {
			if (o.equals("HTML")) {
				dtdLocation = getClass().getResource("xhtml.dtd").toExternalForm();
			}
		}
		try {
			if (dtdLocation != null) {
				if (logger.isDebugEnabled()) {
					logger.debug("Using dtd to build completion database");
				}
				setCompletionParser(new DTDCompletionParser());
				URL url = new java.net.URL(dtdLocation);
				Reader dtdReader = new InputStreamReader(url.openStream());
				updateAssistInfo(null, dtdLocation, dtdReader);
			} else if (schemaLocation != null) {
				if (logger.isDebugEnabled()) {
					logger.debug("Using schema  to build completion database");
				}
				setCompletionParser(new XSDCompletionParser());
				URL url = new java.net.URL(schemaLocation);
				Reader dtdReader = new InputStreamReader(url.openStream());
				updateAssistInfo(null, schemaLocation, dtdReader);
			}
		} catch (Exception err) {
			if (logger.isDebugEnabled()) {
				logger.debug(err.getMessage(), err);
			}
		}
	}

}