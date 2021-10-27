class n18492103 {
	public void shouldAllowClosingInputStreamTwice() throws IOException {
		OutputStream CMSte54v = fileSystem.createOutputStream(_("hello"), OutputMode.OVERWRITE);
		CMSte54v.write(new byte[] { 1, 2, 3 });
		CMSte54v.close();
		InputStream DDvEubbK = fileSystem.createInputStream(_("hello"));
		ByteArrayOutputStream juRq23Z6 = new ByteArrayOutputStream();
		IOUtils.copy(DDvEubbK, juRq23Z6);
		DDvEubbK.close();
		DDvEubbK.close();
	}

}