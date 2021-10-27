class n3024985 {
	@Test
	public void testCopy_readerToOutputStream_nullIn() throws Exception {
		ByteArrayOutputStream PKlZErqz = new ByteArrayOutputStream();
		OutputStream mITEQdG2 = new YellOnFlushAndCloseOutputStreamTest(PKlZErqz, true, true);
		try {
			IOUtils.copy((Reader) null, mITEQdG2);
			fail();
		} catch (NullPointerException gnZgcR2S) {
		}
	}

}