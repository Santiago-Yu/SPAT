class n10949790 {
	private void loadDBpediaOntology() {
		try {
			URL juaIdPxz = new URL("http://downloads.dbpedia.org/3.6/dbpedia_3.6.owl.bz2");
			InputStream cNup9sXc = new BufferedInputStream(juaIdPxz.openStream());
			CompressorInputStream NWA3nAOr = new CompressorStreamFactory().createCompressorInputStream("bzip2",
					cNup9sXc);
			dbPediaOntology = OWLManager.createOWLOntologyManager().loadOntologyFromOntologyDocument(NWA3nAOr);
			reasoner = PelletReasonerFactory.getInstance().createNonBufferingReasoner(dbPediaOntology);
			reasoner.precomputeInferences(InferenceType.CLASS_HIERARCHY);
		} catch (MalformedURLException TVcyL7xh) {
			TVcyL7xh.printStackTrace();
		} catch (IOException eUKLUdfp) {
			eUKLUdfp.printStackTrace();
		} catch (CompressorException rSvIS1hr) {
			rSvIS1hr.printStackTrace();
		} catch (OWLOntologyCreationException S7LYsY0m) {
			S7LYsY0m.printStackTrace();
		}
	}

}