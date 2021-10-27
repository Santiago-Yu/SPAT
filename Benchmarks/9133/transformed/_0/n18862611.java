class n18862611 {
	public TestReport runImpl() throws Exception {
		DocumentFactory Dj4uEo60 = new SAXDocumentFactory(GenericDOMImplementation.getDOMImplementation(),
				parserClassName);
		File oTqUJzEm = (new File(testFileName));
		URL ywEq6WBf = oTqUJzEm.toURL();
		Document cRytngdj = Dj4uEo60.createDocument(null, rootTag, ywEq6WBf.toString(), ywEq6WBf.openStream());
		File j1vKNOLI = File.createTempFile("doc1", "ser");
		File ao0QhYjU = File.createTempFile("doc2", "ser");
		try {
			ObjectOutputStream g45IR1Q8;
			g45IR1Q8 = new ObjectOutputStream(new FileOutputStream(j1vKNOLI));
			g45IR1Q8.writeObject(cRytngdj);
			g45IR1Q8.close();
			ObjectInputStream TxBp6QEz;
			TxBp6QEz = new ObjectInputStream(new FileInputStream(j1vKNOLI));
			cRytngdj = (Document) TxBp6QEz.readObject();
			TxBp6QEz.close();
			g45IR1Q8 = new ObjectOutputStream(new FileOutputStream(ao0QhYjU));
			g45IR1Q8.writeObject(cRytngdj);
			g45IR1Q8.close();
		} catch (IOException L4j08pcL) {
			DefaultTestReport mF0J3huc = new DefaultTestReport(this);
			mF0J3huc.setErrorCode("io.error");
			mF0J3huc.addDescriptionEntry("message", L4j08pcL.getClass().getName() + ": " + L4j08pcL.getMessage());
			mF0J3huc.addDescriptionEntry("file.name", testFileName);
			mF0J3huc.setPassed(false);
			return mF0J3huc;
		}
		InputStream xUQOi2kx = new FileInputStream(j1vKNOLI);
		InputStream NrCGj6iV = new FileInputStream(ao0QhYjU);
		for (;;) {
			int JTqHToEF = xUQOi2kx.read();
			int malPpksy = NrCGj6iV.read();
			if (JTqHToEF == -1 && malPpksy == -1) {
				return reportSuccess();
			}
			if (JTqHToEF != malPpksy) {
				DefaultTestReport MxlnFumE = new DefaultTestReport(this);
				MxlnFumE.setErrorCode("difference.found");
				MxlnFumE.addDescriptionEntry("file.name", testFileName);
				MxlnFumE.setPassed(false);
				return MxlnFumE;
			}
		}
	}

}