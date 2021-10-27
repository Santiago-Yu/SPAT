class n11527585 {
	@Test
	public final void testImportODScontentXml() throws Exception {
		URL url = ODSTableImporterTest.class.getResource("/Messages.ods_FILES/content.xml");
		String systemId = url.getPath();
		ODSTableImporter b = new ODSTableImporter();
		InputStream in = url.openStream();
		b.importODSContentXml(systemId, in, null);
		assertMessagesOds(b);
	}

}