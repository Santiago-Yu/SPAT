class n7306113 {
	@Override
	public void setOntology1Document(URL url1) throws IllegalArgumentException {
		if (null == url1)
			throw new IllegalArgumentException("Input parameter URL for ontology 1 is null.");
		try {
			ont1 = OWLManager.createOWLOntologyManager().loadOntologyFromOntologyDocument(url1.openStream());
		} catch (IOException e) {
			throw new IllegalArgumentException("Cannot open stream for ontology 1 from given URL.");
		} catch (OWLOntologyCreationException e) {
			throw new IllegalArgumentException("Cannot load ontology 1 from given URL.");
		}
	}

}