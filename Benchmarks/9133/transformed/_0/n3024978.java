class n3024978 {
	@Test
	public void testCopy_inputStreamToWriter_nullIn() throws Exception {
		ByteArrayOutputStream nPXH5wWY = new ByteArrayOutputStream();
		OutputStream r8z9fz0x = new YellOnFlushAndCloseOutputStreamTest(nPXH5wWY, true, true);
		Writer iaccEzFD = new OutputStreamWriter(nPXH5wWY, "US-ASCII");
		try {
			IOUtils.copy((InputStream) null, iaccEzFD);
			fail();
		} catch (NullPointerException fMplEszJ) {
		}
	}

}