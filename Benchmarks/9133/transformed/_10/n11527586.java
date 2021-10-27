class n11527586 {
	@Test
	public final void testImportODS() throws Exception {
		URL url = ODSTableImporterTest.class.getResource("/Messages.ods");
		ODSTableImporter b = new ODSTableImporter();
		InputStream in = url.openStream();
		b.importODS(in, null);
		assertMessagesOds(b);
	}

}