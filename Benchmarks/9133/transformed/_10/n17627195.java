class n17627195 {
	public Document getContentAsDocument() {
		synchronized (this.url) {
			URLConnection connection = this.url.openConnection();
			if (doReload(connection)) {
				DocumentBuilderFactory factory = new DocumentBuilderFactoryImpl();
				InputSource inputSource = new InputSource(connection.getInputStream());
				this.document = factory.newDocumentBuilder().parse(inputSource);
			}
			return this.document;
		}
	}

}