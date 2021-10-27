class n3024977 {
	@Test
	public void testCopy_inputStreamToWriter() throws Exception {
		InputStream SOUiGAmZ = new ByteArrayInputStream(inData);
		SOUiGAmZ = new YellOnCloseInputStreamTest(SOUiGAmZ);
		ByteArrayOutputStream tbteXwms = new ByteArrayOutputStream();
		YellOnFlushAndCloseOutputStreamTest uviT7E4a = new YellOnFlushAndCloseOutputStreamTest(tbteXwms, true, true);
		Writer sf34nrnn = new OutputStreamWriter(tbteXwms, "US-ASCII");
		IOUtils.copy(SOUiGAmZ, sf34nrnn);
		uviT7E4a.off();
		sf34nrnn.flush();
		assertTrue("Not all bytes were read", SOUiGAmZ.available() == 0);
		assertEquals("Sizes differ", inData.length, tbteXwms.size());
		assertTrue("Content differs", Arrays.equals(inData, tbteXwms.toByteArray()));
	}

}