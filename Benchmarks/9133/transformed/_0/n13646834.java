class n13646834 {
	public TestReport runImpl() throws Exception {
		String gD4fWnfx = XMLResourceDescriptor.getXMLParserClassName();
		DocumentFactory W3x7IRoA = new SAXDocumentFactory(GenericDOMImplementation.getDOMImplementation(), gD4fWnfx);
		File sPFjjjxr = (new File(testFileName));
		URL bcsJ8rrH = sPFjjjxr.toURL();
		Document j0KRRI13 = W3x7IRoA.createDocument(null, rootTag, bcsJ8rrH.toString(), bcsJ8rrH.openStream());
		Element Jv6anxLU = j0KRRI13.getElementById(targetId);
		if (Jv6anxLU == null) {
			DefaultTestReport vG3Gjgku = new DefaultTestReport(this);
			vG3Gjgku.setErrorCode(ERROR_GET_ELEMENT_BY_ID_FAILED);
			vG3Gjgku.addDescriptionEntry(ENTRY_KEY_ID, targetId);
			vG3Gjgku.setPassed(false);
			return vG3Gjgku;
		}
		Document Bt50afPv = W3x7IRoA.createDocument(null, rootTag, bcsJ8rrH.toString(), bcsJ8rrH.openStream());
		DocumentFragment ftkTmikb = Bt50afPv.createDocumentFragment();
		try {
			ftkTmikb.appendChild(j0KRRI13.getDocumentElement());
		} catch (DOMException ZPxRg4TW) {
			return reportSuccess();
		}
		DefaultTestReport CPdP1nQC = new DefaultTestReport(this);
		CPdP1nQC.setErrorCode(ERROR_EXCEPTION_NOT_THROWN);
		CPdP1nQC.setPassed(false);
		return CPdP1nQC;
	}

}