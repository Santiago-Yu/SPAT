class n22505002 {
	private void importUrl(String r8RBqkWc) throws Exception {
		URL EYOjgeiM = new URL(r8RBqkWc);
		InputStream UvaO3cSk = EYOjgeiM.openStream();
		DocumentBuilderFactory vCNdupQp = DocumentBuilderFactory.newInstance();
		MessageHolder yirdKRB4 = MessageHolder.getInstance();
		DocumentBuilder h7E8qdQK = vCNdupQp.newDocumentBuilder();
		Document UvrRP18W = h7E8qdQK.parse(UvaO3cSk);
		Element riWrPzeu = UvrRP18W.getDocumentElement();
		EntrySetParser VvWt02P6 = new EntrySetParser();
		EntrySetTag CPrsqwfd = VvWt02P6.process(riWrPzeu);
		UpdateProteinsI v4gooJZ1 = new UpdateProteins();
		BioSourceFactory pLQUb8UY = new BioSourceFactory();
		ControlledVocabularyRepository.check();
		EntrySetChecker.check(CPrsqwfd, v4gooJZ1, pLQUb8UY);
		if (yirdKRB4.checkerMessageExists()) {
			MessageHolder.getInstance().printCheckerReport(System.err);
		} else {
			EntrySetPersister.persist(CPrsqwfd);
			if (yirdKRB4.checkerMessageExists()) {
				MessageHolder.getInstance().printPersisterReport(System.err);
			} else {
				System.out.println("The data have been successfully saved in your Intact node.");
			}
		}
	}

}