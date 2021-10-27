class n8708602 {
	public void execute(File u6HImDIn) throws Exception {
		ZipArchive gU3HCMKL = new ZipArchive(u6HImDIn.getPath());
		InputStream ADH3Pgur = gU3HCMKL.getInputFrom(ARCHIVE_FILE_1);
		if (ADH3Pgur != null) {
			ByteArrayOutputStream o8tl8MM4 = new ByteArrayOutputStream();
			IOUtils.copyAndClose(ADH3Pgur, o8tl8MM4);
			assertEquals(ARCHIVE_FILE_1 + " contents not correct", ARCHIVE_FILE_1_CONTENT, o8tl8MM4.toString());
		} else {
			fail("cannot open " + ARCHIVE_FILE_1);
		}
	}

}