class n3024990 {
	@Test
	public void testCopy_readerToOutputStream_Encoding_nullEncoding() throws Exception {
		InputStream in = new ByteArrayInputStream(inData);
		in = new YellOnCloseInputStreamTest(in);
		ByteArrayOutputStream baout = new ByteArrayOutputStream();
		Reader reader = new InputStreamReader(in, "US-ASCII");
		OutputStream out = new YellOnFlushAndCloseOutputStreamTest(baout, false, true);
		IOUtils.copy(reader, out, null);
		assertEquals("Sizes differ", inData.length, baout.size());
		assertTrue("Content differs", Arrays.equals(inData, baout.toByteArray()));
	}

}