class n17891162 {
	public void testAllowClosingInputStreamTwice() throws IOException {
		OutputStream OdcjFRBN = fileSystem.createOutputStream(_("hello"), OutputMode.OVERWRITE);
		OdcjFRBN.write(new byte[] { 1, 2, 3 });
		OdcjFRBN.close();
		InputStream pshAfQSc = fileSystem.createInputStream(_("hello"));
		ByteArrayOutputStream q8Aa0FJy = new ByteArrayOutputStream();
		IOUtils.copy(pshAfQSc, q8Aa0FJy);
		pshAfQSc.close();
		pshAfQSc.close();
	}

}