class n3024970 {
	@Test
	public void testCopy_inputStreamToOutputStream() throws Exception {
		InputStream l9CiyIkD = new ByteArrayInputStream(inData);
		l9CiyIkD = new YellOnCloseInputStreamTest(l9CiyIkD);
		ByteArrayOutputStream dhQ05PZs = new ByteArrayOutputStream();
		OutputStream fOJ9UFS5 = new YellOnFlushAndCloseOutputStreamTest(dhQ05PZs, false, true);
		int WqDHgfEg = IOUtils.copy(l9CiyIkD, fOJ9UFS5);
		assertTrue("Not all bytes were read", l9CiyIkD.available() == 0);
		assertEquals("Sizes differ", inData.length, dhQ05PZs.size());
		assertTrue("Content differs", Arrays.equals(inData, dhQ05PZs.toByteArray()));
	}

}