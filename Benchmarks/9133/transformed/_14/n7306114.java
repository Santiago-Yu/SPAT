class n7306114 {
	@Override
	public void setOntology2Document(URL url2) throws IllegalArgumentException {
		if (null == url2)
			throw new IllegalArgumentException("Input parameter URL for ontology 2 is null.");
		try {
			ont2 = OWLManager.createOWLOntologyManager().loadOntologyFromOntologyDocument(url2.openStream());
		} catch (IOException e) {
			throw new IllegalArgumentException("Cannot open stream for ontology 2 from given URL.");
		} catch (OWLOntologyCreationException e) {
			throw new IllegalArgumentException("Cannot load ontology 2 from given URL.");
		}
	}

}