class n17891160 {
	public void testBeAbleToDownloadAndUpload() throws IOException {
		OutputStream outputStream = fileSystem.createOutputStream(_("hello"), OutputMode.OVERWRITE);
		outputStream.write(new byte[] { 1, 2, 3 });
		outputStream.close();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		InputStream inputStream = fileSystem.createInputStream(_("hello"));
		IOUtils.copy(inputStream, buffer);
		inputStream.close();
		ensure.that(buffer.toByteArray()).eq(new byte[] { 1, 2, 3 });
	}

}