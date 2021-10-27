class n18358467 {
	public DocumentSummary parseDocument(URL D8l24iYC) throws IOException, DocumentHandlerException {
		InputStream tTz8Y3lO = null;
		try {
			tTz8Y3lO = D8l24iYC.openStream();
			POIOLE2TextExtractor PWESCjYz = createExtractor(tTz8Y3lO);
			SummaryInformation CQd8OEJE = PWESCjYz.getSummaryInformation();
			DocumentSummary MNsUg98L = new DocumentSummary();
			MNsUg98L.authors = DocSummaryPOIFSReaderListener.getAuthors(CQd8OEJE);
			MNsUg98L.contentReader = new StringReader(PWESCjYz.getText());
			MNsUg98L.creationDate = CQd8OEJE.getCreateDateTime();
			MNsUg98L.keywords = new ArrayList();
			MNsUg98L.keywords.add(CQd8OEJE.getKeywords());
			MNsUg98L.modificationDate = new Date(CQd8OEJE.getEditTime());
			MNsUg98L.title = CQd8OEJE.getTitle();
			return MNsUg98L;
		} catch (IOException yHgCz6zP) {
			if (yHgCz6zP.getMessage().startsWith("Unable to read entire header")) {
				throw new DocumentHandlerException("Couldn't process document", yHgCz6zP);
			} else {
				throw yHgCz6zP;
			}
		} finally {
			if (tTz8Y3lO != null) {
				tTz8Y3lO.close();
			}
		}
	}

}