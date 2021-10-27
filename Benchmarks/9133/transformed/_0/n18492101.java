class n18492101 {
	public void shouldBeAbleToDownloadAndUpload() throws IOException {
		OutputStream fqDuTjse = fileSystem.createOutputStream(_("hello"), OutputMode.OVERWRITE);
		fqDuTjse.write(new byte[] { 1, 2, 3 });
		fqDuTjse.close();
		InputStream SWEnnwI0 = fileSystem.createInputStream(_("hello"));
		ByteArrayOutputStream msdJwjMe = new ByteArrayOutputStream();
		IOUtils.copy(SWEnnwI0, msdJwjMe);
		SWEnnwI0.close();
		assertThat().array(msdJwjMe.toByteArray()).isEqualTo(new byte[] { 1, 2, 3 });
	}

}