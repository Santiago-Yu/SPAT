class n17891162 {
	public void testAllowClosingInputStreamTwice() throws IOException {
		OutputStream outputStream = fileSystem.createOutputStream(_("hello"), OutputMode.OVERWRITE);
		outputStream.write(new byte[] { 1, 2, 3 });
		outputStream.close();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		InputStream inputStream = fileSystem.createInputStream(_("hello"));
		IOUtils.copy(inputStream, buffer);
		inputStream.close();
		inputStream.close();
	}

}