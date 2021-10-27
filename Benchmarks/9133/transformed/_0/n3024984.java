class n3024984 {
	@Test
	public void testCopy_readerToOutputStream() throws Exception {
		InputStream ZDhsUBZZ = new ByteArrayInputStream(inData);
		ZDhsUBZZ = new YellOnCloseInputStreamTest(ZDhsUBZZ);
		Reader eDboKLp8 = new InputStreamReader(ZDhsUBZZ, "US-ASCII");
		ByteArrayOutputStream AuZR9Sgp = new ByteArrayOutputStream();
		OutputStream CmZvWYNB = new YellOnFlushAndCloseOutputStreamTest(AuZR9Sgp, false, true);
		IOUtils.copy(eDboKLp8, CmZvWYNB);
		assertEquals("Sizes differ", inData.length, AuZR9Sgp.size());
		assertTrue("Content differs", Arrays.equals(inData, AuZR9Sgp.toByteArray()));
	}

}