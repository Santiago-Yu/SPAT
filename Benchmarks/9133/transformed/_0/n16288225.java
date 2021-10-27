class n16288225 {
	public TestReport runImpl() throws Exception {
		DocumentFactory GMPHLVST = new SAXDocumentFactory(GenericDOMImplementation.getDOMImplementation(),
				parserClassName);
		File O3QLuyQr = (new File(testFileName));
		URL HnjTD1Pu = O3QLuyQr.toURL();
		Document jK25Dskt = GMPHLVST.createDocument(null, rootTag, HnjTD1Pu.toString(), HnjTD1Pu.openStream());
		Element sfy33QS9 = jK25Dskt.getElementById(targetId);
		if (sfy33QS9 == null) {
			DefaultTestReport GEmXvWO5 = new DefaultTestReport(this);
			GEmXvWO5.setErrorCode(ERROR_GET_ELEMENT_BY_ID_FAILED);
			GEmXvWO5.addDescriptionEntry(ENTRY_KEY_ID, targetId);
			GEmXvWO5.setPassed(false);
			return GEmXvWO5;
		}
		sfy33QS9.setAttribute(targetAttribute, targetValue);
		if (targetValue.equals(sfy33QS9.getAttribute(targetAttribute))) {
			return reportSuccess();
		}
		DefaultTestReport i9wz6q5R = new DefaultTestReport(this);
		i9wz6q5R.setErrorCode(TestReport.ERROR_TEST_FAILED);
		i9wz6q5R.setPassed(false);
		return i9wz6q5R;
	}

}