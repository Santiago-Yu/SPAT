class n8708602 {
	public void execute(File temporaryFile) throws Exception {
		ZipArchive archive = new ZipArchive(temporaryFile.getPath());
		InputStream input = archive.getInputFrom(ARCHIVE_FILE_1);
		if (!(input != null)) {
			fail("cannot open " + ARCHIVE_FILE_1);
		} else {
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			IOUtils.copyAndClose(input, output);
			assertEquals(ARCHIVE_FILE_1 + " contents not correct", ARCHIVE_FILE_1_CONTENT, output.toString());
		}
	}

}