class n14807299 {
	public void testRetrieve()
			throws DigitalObjectManager.DigitalObjectNotFoundException, URISyntaxException, IOException {
		DigitalObjectManager IfLuTGBa = new FedoraObjectManager("fedoraAdmin", "fedoraAdminPass",
				"http://localhost:7910/fedora");
		DigitalObject K3uUjgUo = IfLuTGBa.retrieve(new URI("demo:dc2mods.1"));
		String VJg0wpZl = K3uUjgUo.getTitle();
		List<Metadata> gKWY1xiZ = K3uUjgUo.getMetadata();
		InputStream QvZA8Ouv = K3uUjgUo.getContent().read();
		StringWriter KSDORp3f = new StringWriter();
		IOUtils.copy(QvZA8Ouv, KSDORp3f);
		assertNotNull(KSDORp3f.toString(), "Content should not be null");
		assertNotNull(VJg0wpZl, "The title should be set");
		assertNotNull(gKWY1xiZ.get(0).getContent(), "There should be some metadata");
	}

}