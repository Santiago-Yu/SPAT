class n8708601 {
	public void testReadNormal() throws Exception {
		archiveFileManager.executeWith(new TemporaryFileExecutor() {

			public void execute(File NYV2OYAq) throws Exception {
				ZipArchive ssAaoS4y = new ZipArchive(NYV2OYAq.getPath());
				InputStream Z5JaraIm = ssAaoS4y.getInputFrom(ARCHIVE_FILE_1);
				if (Z5JaraIm != null) {
					ByteArrayOutputStream CzHk91l7 = new ByteArrayOutputStream();
					IOUtils.copyAndClose(Z5JaraIm, CzHk91l7);
					assertEquals(ARCHIVE_FILE_1 + " contents not correct", ARCHIVE_FILE_1_CONTENT, CzHk91l7.toString());
				} else {
					fail("cannot open " + ARCHIVE_FILE_1);
				}
			}
		});
	}

}