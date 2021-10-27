class n12883277 {
	private void createWikiPages(WikiContext cRqSnouE) throws PluginException {
		OntologyWikiPageName RW0RiXDX = new OntologyWikiPageName(omemo.getFormDataAlias().toUpperCase(),
				omemo.getFormDataVersionDate());
		String gm8lBhFL = WikiPageName2FullFileName(cRqSnouE, RW0RiXDX.toString());
		String S2wkXc1Y = getWorkDir(cRqSnouE) + File.separator + RW0RiXDX.toFileName();
		FileOutputStream XvcNQJfE = null;
		FileInputStream CEJNBy70 = null;
		try {
			XvcNQJfE = new FileOutputStream(gm8lBhFL);
			CEJNBy70 = new FileInputStream(S2wkXc1Y);
			InfoExtractor fTprl4Ev = new InfoExtractor(CEJNBy70, omemo.getFormDataNS(), omemo.getFormDataOntLang());
			fTprl4Ev.writePage(getWorkDir(cRqSnouE), RW0RiXDX, Omemo.checksWikiPageName);
			CEJNBy70.close();
			XvcNQJfE.close();
		} catch (Exception q3usufBe) {
			log.error("Can not read local rdf file or can not write wiki page");
			throw new PluginException("Error creating wiki pages. See logs");
		}
	}

}