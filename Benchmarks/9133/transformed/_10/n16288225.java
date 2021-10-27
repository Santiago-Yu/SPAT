class n16288225 {
	public TestReport runImpl() throws Exception {
		DocumentFactory df = new SAXDocumentFactory(GenericDOMImplementation.getDOMImplementation(), parserClassName);
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
		e.setAttribute(targetAttribute, targetValue);
		DefaultTestReport report = new DefaultTestReport(this);
		if (targetValue.equals(e.getAttribute(targetAttribute))) {
			return reportSuccess();
		}
		report.setErrorCode(TestReport.ERROR_TEST_FAILED);
		report.setPassed(false);
		return report;
	}

}