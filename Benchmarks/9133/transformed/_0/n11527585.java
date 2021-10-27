class n11527585 {
	@Test
	public final void testImportODScontentXml() throws Exception {
		URL PRS4IiWY = ODSTableImporterTest.class.getResource("/Messages.ods_FILES/content.xml");
		String gKGYARba = PRS4IiWY.getPath();
		InputStream j2Dtjm0o = PRS4IiWY.openStream();
		ODSTableImporter POcrhNd6 = new ODSTableImporter();
		POcrhNd6.importODSContentXml(gKGYARba, j2Dtjm0o, null);
		assertMessagesOds(POcrhNd6);
	}

}