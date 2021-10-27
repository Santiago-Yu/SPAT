class n19058139 {
	public void init(final javax.swing.text.Document ovsu0LfG) {
		this.doc = ovsu0LfG;
		String nSuQlvmF = null;
		String s4DPh8S5 = null;
		SyntaxDocument L1xKdxps = (SyntaxDocument) ovsu0LfG;
		Object stmEZbsK = L1xKdxps.getProperty(XPontusConstantsIF.PARSER_DATA_DTD_COMPLETION_INFO);
		Object pumhnp9o = L1xKdxps.getProperty(XPontusConstantsIF.PARSER_DATA_SCHEMA_COMPLETION_INFO);
		if (stmEZbsK != null) {
			nSuQlvmF = stmEZbsK.toString();
		}
		if (pumhnp9o != null) {
			s4DPh8S5 = pumhnp9o.toString();
		}
		Object MhBXNZSY = ovsu0LfG.getProperty("BUILTIN_COMPLETION");
		if (MhBXNZSY != null) {
			if (MhBXNZSY.equals("HTML")) {
				nSuQlvmF = getClass().getResource("xhtml.dtd").toExternalForm();
			}
		}
		try {
			if (nSuQlvmF != null) {
				if (logger.isDebugEnabled()) {
					logger.debug("Using dtd to build completion database");
				}
				setCompletionParser(new DTDCompletionParser());
				URL lcHa7mHt = new java.net.URL(nSuQlvmF);
				Reader ecXLZUiR = new InputStreamReader(lcHa7mHt.openStream());
				updateAssistInfo(null, nSuQlvmF, ecXLZUiR);
			} else if (s4DPh8S5 != null) {
				if (logger.isDebugEnabled()) {
					logger.debug("Using schema  to build completion database");
				}
				setCompletionParser(new XSDCompletionParser());
				URL BQp4OEpg = new java.net.URL(s4DPh8S5);
				Reader kXiHIjjh = new InputStreamReader(BQp4OEpg.openStream());
				updateAssistInfo(null, s4DPh8S5, kXiHIjjh);
			}
		} catch (Exception xicw1lZA) {
			if (logger.isDebugEnabled()) {
				logger.debug(xicw1lZA.getMessage(), xicw1lZA);
			}
		}
	}

}