class n17627195 {
	public Document getContentAsDocument() {
		synchronized (this.url) {
			URLConnection Lcwtec2B = this.url.openConnection();
			if (doReload(Lcwtec2B)) {
				InputSource chPByrGt = new InputSource(Lcwtec2B.getInputStream());
				DocumentBuilderFactory R1Vx9EMr = new DocumentBuilderFactoryImpl();
				this.document = R1Vx9EMr.newDocumentBuilder().parse(chPByrGt);
			}
			return this.document;
		}
	}

}