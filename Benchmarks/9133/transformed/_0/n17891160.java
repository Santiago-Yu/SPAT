class n17891160 {
	public void testBeAbleToDownloadAndUpload() throws IOException {
		OutputStream gelCZYB9 = fileSystem.createOutputStream(_("hello"), OutputMode.OVERWRITE);
		gelCZYB9.write(new byte[] { 1, 2, 3 });
		gelCZYB9.close();
		InputStream WK5HKROo = fileSystem.createInputStream(_("hello"));
		ByteArrayOutputStream PlB4N15j = new ByteArrayOutputStream();
		IOUtils.copy(WK5HKROo, PlB4N15j);
		WK5HKROo.close();
		ensure.that(PlB4N15j.toByteArray()).eq(new byte[] { 1, 2, 3 });
	}

}