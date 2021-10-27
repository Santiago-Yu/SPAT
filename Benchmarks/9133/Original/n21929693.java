class n21929693{
    private void importUrl(String str) throws Exception {
        URL url = new URL(str);
        InputStream xmlStream = url.openStream();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        MessageHolder messages = MessageHolder.getInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlStream);
        Element rootElement = document.getDocumentElement();
        EntrySetParser entrySetParser = new EntrySetParser();
        EntrySetTag entrySet = entrySetParser.process(rootElement);
        UpdateProteinsI proteinFactory = new UpdateProteins();
        BioSourceFactory bioSourceFactory = new BioSourceFactory();
        ControlledVocabularyRepository.check();
        EntrySetChecker.check(entrySet, proteinFactory, bioSourceFactory);
        if (messages.checkerMessageExists()) {
            MessageHolder.getInstance().printCheckerReport(System.err);
        } else {
            EntrySetPersister.persist(entrySet);
            if (messages.checkerMessageExists()) {
                MessageHolder.getInstance().printPersisterReport(System.err);
            } else {
                System.out.println("The data have been successfully saved in your Intact node.");
            }
        }
    }

}