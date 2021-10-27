class n3024990 {
	@Test
	public void testCopy_readerToOutputStream_Encoding_nullEncoding() throws Exception {
		InputStream bdGbcyMq = new ByteArrayInputStream(inData);
		bdGbcyMq = new YellOnCloseInputStreamTest(bdGbcyMq);
		Reader QH9mmhdZ = new InputStreamReader(bdGbcyMq, "US-ASCII");
		ByteArrayOutputStream WSyiMrkh = new ByteArrayOutputStream();
		OutputStream FSHbQ2Hh = new YellOnFlushAndCloseOutputStreamTest(WSyiMrkh, false, true);
		IOUtils.copy(QH9mmhdZ, FSHbQ2Hh, null);
		assertEquals("Sizes differ", inData.length, WSyiMrkh.size());
		assertTrue("Content differs", Arrays.equals(inData, WSyiMrkh.toByteArray()));
	}

}