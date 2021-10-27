class n3024970 {
	@Test
	public void testCopy_inputStreamToOutputStream() throws Exception {
		InputStream in = new ByteArrayInputStream(inData);
		ByteArrayOutputStream baout = new ByteArrayOutputStream();
		in = new YellOnCloseInputStreamTest(in);
		OutputStream out = new YellOnFlushAndCloseOutputStreamTest(baout, false, true);
		int count = IOUtils.copy(in, out);
		assertTrue("Not all bytes were read", in.available() == 0);
		assertEquals("Sizes differ", inData.length, baout.size());
		assertTrue("Content differs", Arrays.equals(inData, baout.toByteArray()));
	}

}