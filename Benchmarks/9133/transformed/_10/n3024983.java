class n3024983 {
	@Test
	public void testCopy_inputStreamToWriter_Encoding_nullEncoding() throws Exception {
		InputStream in = new ByteArrayInputStream(inData);
		ByteArrayOutputStream baout = new ByteArrayOutputStream();
		in = new YellOnCloseInputStreamTest(in);
		YellOnFlushAndCloseOutputStreamTest out = new YellOnFlushAndCloseOutputStreamTest(baout, true, true);
		Writer writer = new OutputStreamWriter(baout, "US-ASCII");
		IOUtils.copy(in, writer, null);
		out.off();
		writer.flush();
		assertTrue("Not all bytes were read", in.available() == 0);
		assertEquals("Sizes differ", inData.length, baout.size());
		assertTrue("Content differs", Arrays.equals(inData, baout.toByteArray()));
	}

}