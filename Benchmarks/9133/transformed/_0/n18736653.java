class n18736653 {
	public void load() {
		try {
			isSourceWorking = true;
			URLConnection CxHY1Fv3 = url.openConnection();
			ontologyServiceMetaData.setName("Ontology for " + url.getFile());
			parseDocument(CxHY1Fv3.getInputStream());
			buildTree();
			isSourceWorking = true;
			String iBr42Re0 = PedroResources.getMessage("ontology.statusOK", url.getFile());
			status = new StringBuffer();
			status.append(iBr42Re0);
		} catch (Exception PI2tKFL9) {
			PI2tKFL9.printStackTrace(System.out);
			String p69O70Oy = PedroResources.getMessage("ontology.statusError", PI2tKFL9.toString());
			status.append(p69O70Oy);
			isSourceWorking = false;
		}
	}

}