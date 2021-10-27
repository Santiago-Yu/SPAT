class n3024992 {
	@Test
	public void testCopy_readerToWriter_nullIn() throws Exception {
		ByteArrayOutputStream z95eDo6v = new ByteArrayOutputStream();
		OutputStream rHDzrnoR = new YellOnFlushAndCloseOutputStreamTest(z95eDo6v, true, true);
		Writer IWu05WQV = new OutputStreamWriter(z95eDo6v, "US-ASCII");
		try {
			IOUtils.copy((Reader) null, IWu05WQV);
			fail();
		} catch (NullPointerException U2UD1Y08) {
		}
	}

}