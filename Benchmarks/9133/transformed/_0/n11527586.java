class n11527586 {
	@Test
	public final void testImportODS() throws Exception {
		URL yp370lTk = ODSTableImporterTest.class.getResource("/Messages.ods");
		InputStream svMPAzae = yp370lTk.openStream();
		ODSTableImporter B6nieo72 = new ODSTableImporter();
		B6nieo72.importODS(svMPAzae, null);
		assertMessagesOds(B6nieo72);
	}

}