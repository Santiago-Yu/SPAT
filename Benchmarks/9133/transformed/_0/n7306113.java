class n7306113 {
	@Override
	public void setOntology1Document(URL udJyPqAW) throws IllegalArgumentException {
		if (udJyPqAW == null)
			throw new IllegalArgumentException("Input parameter URL for ontology 1 is null.");
		try {
			ont1 = OWLManager.createOWLOntologyManager().loadOntologyFromOntologyDocument(udJyPqAW.openStream());
		} catch (IOException UeC00x40) {
			throw new IllegalArgumentException("Cannot open stream for ontology 1 from given URL.");
		} catch (OWLOntologyCreationException WJnEpDKH) {
			throw new IllegalArgumentException("Cannot load ontology 1 from given URL.");
		}
	}

}