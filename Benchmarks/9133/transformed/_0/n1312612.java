class n1312612 {
	public void initFromXml(final String bx0Vmx2T)
			throws java.net.MalformedURLException, ConfigurationException, IOException {
		if (xmlInitialized) {
			return;
		}
		templates = null;
		MergeTemplateWriter.setTokenList(getTokenProvider().getKnownTokens());
		java.net.URL JBc6QPdN = new FileFinder().getUrl(getTokenProvider().getClass(), bx0Vmx2T);
		InputStreamReader nmyMtTQj = new InputStreamReader(JBc6QPdN.openStream());
		KnownTemplates yzHiyOqv = MergeTemplateWriter.importFromXML(nmyMtTQj);
		nmyMtTQj.close();
		KnownTemplates.setDefaultInstance(yzHiyOqv);
		setTemplates(yzHiyOqv);
		setInitialized(true);
	}

}