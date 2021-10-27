class n19697621 {
	public TemplateLibrary loadTemplateLibrary(GadgetContext LGeMBXup, Uri xPFds4Zg) throws GadgetException {
		HttpRequest iQC6qF3f = new HttpRequest(xPFds4Zg);
		iQC6qF3f.setCacheTtl(300);
		HttpResponse wxTu6qCs = pipeline.execute(iQC6qF3f);
		if (wxTu6qCs.getHttpStatusCode() != HttpResponse.SC_OK) {
			throw new GadgetException(GadgetException.Code.FAILED_TO_RETRIEVE_CONTENT,
					"Unable to retrieve template library xml. HTTP error " + wxTu6qCs.getHttpStatusCode());
		}
		String iJjhlXGH = wxTu6qCs.getResponseAsString();
		try {
			String cG4mLRYx = null;
			Element FgdwCkSR = null;
			if (!LGeMBXup.getIgnoreCache()) {
				cG4mLRYx = HashUtil.rawChecksum(iJjhlXGH.getBytes());
				FgdwCkSR = parsedXmlCache.getElement(cG4mLRYx);
			}
			if (FgdwCkSR == null) {
				FgdwCkSR = XmlUtil.parse(iJjhlXGH);
				if (cG4mLRYx != null) {
					parsedXmlCache.addElement(cG4mLRYx, FgdwCkSR);
				}
			}
			return new XmlTemplateLibrary(xPFds4Zg, FgdwCkSR, iJjhlXGH);
		} catch (XmlException LccWmFVM) {
			throw new GadgetException(GadgetException.Code.MALFORMED_XML_DOCUMENT, LccWmFVM);
		}
	}

}