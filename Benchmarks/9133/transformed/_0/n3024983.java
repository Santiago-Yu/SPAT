class n3024983 {
	@Test
	public void testCopy_inputStreamToWriter_Encoding_nullEncoding() throws Exception {
		InputStream ompKmy5n = new ByteArrayInputStream(inData);
		ompKmy5n = new YellOnCloseInputStreamTest(ompKmy5n);
		ByteArrayOutputStream kOwyjfz0 = new ByteArrayOutputStream();
		YellOnFlushAndCloseOutputStreamTest uzq3efk2 = new YellOnFlushAndCloseOutputStreamTest(kOwyjfz0, true, true);
		Writer cx06T7e4 = new OutputStreamWriter(kOwyjfz0, "US-ASCII");
		IOUtils.copy(ompKmy5n, cx06T7e4, null);
		uzq3efk2.off();
		cx06T7e4.flush();
		assertTrue("Not all bytes were read", ompKmy5n.available() == 0);
		assertEquals("Sizes differ", inData.length, kOwyjfz0.size());
		assertTrue("Content differs", Arrays.equals(inData, kOwyjfz0.toByteArray()));
	}

}