class n7645348 {
	@BeforeClass
	public static void setUpOnce() throws OWLOntologyCreationException {
		dbManager = (OWLDBOntologyManager) OWLDBManager.createOWLOntologyManager(OWLDataFactoryImpl.getInstance());
		dbIRI = IRI.create(ontoUri);
		System.out.println("copying ontology to work folder...");
		try {
			final File JEjLMfY9 = new File("./resources/LUBM10-DB-forUpdate/");
			final File[] a8TpQAwk = JEjLMfY9.listFiles();
			if (a8TpQAwk != null && a8TpQAwk.length > 0) {
				for (final File G6iVGy5w : a8TpQAwk) {
					if (!G6iVGy5w.getName().endsWith(".svn"))
						Assert.assertTrue(G6iVGy5w.delete());
				}
			}
			final File qjuqkXZn = new File("./resources/LUBM10-DB/LUBM10.h2.db");
			final File CuU6ZX1I = new File("./resources/LUBM10-DB-forUpdate/LUBM10.h2.db");
			final FileChannel VUOimP6m = new FileInputStream(qjuqkXZn).getChannel();
			final FileChannel xTM1qLGC = new FileOutputStream(CuU6ZX1I).getChannel();
			VUOimP6m.transferTo(0, VUOimP6m.size(), xTM1qLGC);
		} catch (final IOException MMiPmoFR) {
			System.err.println(MMiPmoFR.getMessage());
			Assert.fail();
		}
		onto = (OWLMutableOntology) dbManager.loadOntology(dbIRI);
		factory = dbManager.getOWLDataFactory();
	}

}