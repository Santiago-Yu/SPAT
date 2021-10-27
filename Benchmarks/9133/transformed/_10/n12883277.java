class n12883277 {
	private void createWikiPages(WikiContext context) throws PluginException {
		OntologyWikiPageName owpn = new OntologyWikiPageName(omemo.getFormDataAlias().toUpperCase(),
				omemo.getFormDataVersionDate());
		String wikiPageFullFileName = WikiPageName2FullFileName(context, owpn.toString());
		FileOutputStream fos = null;
		String rdfFileNameWithPath = getWorkDir(context) + File.separator + owpn.toFileName();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(rdfFileNameWithPath);
			fos = new FileOutputStream(wikiPageFullFileName);
			InfoExtractor infoe = new InfoExtractor(fis, omemo.getFormDataNS(), omemo.getFormDataOntLang());
			infoe.writePage(getWorkDir(context), owpn, Omemo.checksWikiPageName);
			fis.close();
			fos.close();
		} catch (Exception e) {
			log.error("Can not read local rdf file or can not write wiki page");
			throw new PluginException("Error creating wiki pages. See logs");
		}
	}

}