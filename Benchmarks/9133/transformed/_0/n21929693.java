class n21929693 {
	private void importUrl(String u2C32n5U) throws Exception {
		URL prFKHB8T = new URL(u2C32n5U);
		InputStream sOgZKc2O = prFKHB8T.openStream();
		DocumentBuilderFactory CffXw3cI = DocumentBuilderFactory.newInstance();
		MessageHolder IuiC3HtD = MessageHolder.getInstance();
		DocumentBuilder PIxZHYkD = CffXw3cI.newDocumentBuilder();
		Document g5ltkStt = PIxZHYkD.parse(sOgZKc2O);
		Element Lj8oTH3L = g5ltkStt.getDocumentElement();
		EntrySetParser KQtjSnj4 = new EntrySetParser();
		EntrySetTag gU7qMzg9 = KQtjSnj4.process(Lj8oTH3L);
		UpdateProteinsI TmvqNdsk = new UpdateProteins();
		BioSourceFactory gZ3uAVIh = new BioSourceFactory();
		ControlledVocabularyRepository.check();
		EntrySetChecker.check(gU7qMzg9, TmvqNdsk, gZ3uAVIh);
		if (IuiC3HtD.checkerMessageExists()) {
			MessageHolder.getInstance().printCheckerReport(System.err);
		} else {
			EntrySetPersister.persist(gU7qMzg9);
			if (IuiC3HtD.checkerMessageExists()) {
				MessageHolder.getInstance().printPersisterReport(System.err);
			} else {
				System.out.println("The data have been successfully saved in your Intact node.");
			}
		}
	}

}