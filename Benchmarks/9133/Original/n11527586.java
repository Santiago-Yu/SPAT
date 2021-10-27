class n11527586{
    @Test
    public final void testImportODS() throws Exception {
        URL url = ODSTableImporterTest.class.getResource("/Messages.ods");
        InputStream in = url.openStream();
        ODSTableImporter b = new ODSTableImporter();
        b.importODS(in, null);
        assertMessagesOds(b);
    }

}