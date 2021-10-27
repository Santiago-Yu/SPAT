class n7131421 {
	private void getEventHeapsFromWeb() {
		try {
			URL l1tIEfAf = getServersURL();
			InputStream iQZCz9yB = l1tIEfAf.openStream();
			Document sjxS4aFQ = factory.newDocumentBuilder().parse(iQZCz9yB);
			readFromDocument(sjxS4aFQ);
		} catch (Exception v6HXokZT) {
			v6HXokZT.printStackTrace();
		}
	}

}