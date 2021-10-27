class n3024988 {
	@Test
	public void testCopy_readerToOutputStream_Encoding_nullIn() throws Exception {
		ByteArrayOutputStream h638HmZX = new ByteArrayOutputStream();
		OutputStream tK4dvwLV = new YellOnFlushAndCloseOutputStreamTest(h638HmZX, true, true);
		try {
			IOUtils.copy((Reader) null, tK4dvwLV, "UTF16");
			fail();
		} catch (NullPointerException GfJuZnPN) {
		}
	}

}