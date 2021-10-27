class n18492101 {
	public void shouldBeAbleToDownloadAndUpload() throws IOException {
		OutputStream outputStream = fileSystem.createOutputStream(_("hello"), OutputMode.OVERWRITE);
		outputStream.write(new byte[] { 1, 2, 3 });
		outputStream.close();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		InputStream inputStream = fileSystem.createInputStream(_("hello"));
		IOUtils.copy(inputStream, buffer);
		inputStream.close();
		assertThat().array(buffer.toByteArray()).isEqualTo(new byte[] { 1, 2, 3 });
	}

}