class n13646834 {
	public TestReport runImpl() throws Exception {
		String parser = XMLResourceDescriptor.getXMLParserClassName();
		DocumentFactory df = new SAXDocumentFactory(GenericDOMImplementation.getDOMImplementation(), parser);
		File f = (new File(testFileName));
		URL url = f.toURL();
		Document doc = df.createDocument(null, rootTag, url.toString(), url.openStream());
		Element e = doc.getElementById(targetId);
		if (e == null) {
			DefaultTestReport report = new DefaultTestReport(this);
			report.setErrorCode(ERROR_GET_ELEMENT_BY_ID_FAILED);
			report.addDescriptionEntry(ENTRY_KEY_ID, targetId);
			report.setPassed(false);
			return report;
		}
		Document otherDocument = df.createDocument(null, rootTag, url.toString(), url.openStream());
		DocumentFragment docFrag = otherDocument.createDocumentFragment();
		DefaultTestReport report = new DefaultTestReport(this);
		try {
			docFrag.appendChild(doc.getDocumentElement());
		} catch (DOMException ex) {
			return reportSuccess();
		}
		report.setErrorCode(ERROR_EXCEPTION_NOT_THROWN);
		report.setPassed(false);
		return report;
	}

}