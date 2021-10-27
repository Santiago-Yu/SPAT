class n7306114 {
	@Override
	public void setOntology2Document(URL FpAevrGE) throws IllegalArgumentException {
		if (FpAevrGE == null)
			throw new IllegalArgumentException("Input parameter URL for ontology 2 is null.");
		try {
			ont2 = OWLManager.createOWLOntologyManager().loadOntologyFromOntologyDocument(FpAevrGE.openStream());
		} catch (IOException VVfV0jYp) {
			throw new IllegalArgumentException("Cannot open stream for ontology 2 from given URL.");
		} catch (OWLOntologyCreationException S2Z3Z4yQ) {
			throw new IllegalArgumentException("Cannot load ontology 2 from given URL.");
		}
	}

}