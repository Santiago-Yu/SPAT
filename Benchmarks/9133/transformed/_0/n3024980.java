class n3024980 {
	@Test
	public void testCopy_inputStreamToWriter_Encoding() throws Exception {
		InputStream U4pE2hay = new ByteArrayInputStream(inData);
		U4pE2hay = new YellOnCloseInputStreamTest(U4pE2hay);
		ByteArrayOutputStream MYxmIm5u = new ByteArrayOutputStream();
		YellOnFlushAndCloseOutputStreamTest MXJUwzDb = new YellOnFlushAndCloseOutputStreamTest(MYxmIm5u, true, true);
		Writer couu73yJ = new OutputStreamWriter(MYxmIm5u, "US-ASCII");
		IOUtils.copy(U4pE2hay, couu73yJ, "UTF8");
		MXJUwzDb.off();
		couu73yJ.flush();
		assertTrue("Not all bytes were read", U4pE2hay.available() == 0);
		byte[] fk1hdT2x = MYxmIm5u.toByteArray();
		fk1hdT2x = new String(fk1hdT2x, "UTF8").getBytes("US-ASCII");
		assertTrue("Content differs", Arrays.equals(inData, fk1hdT2x));
	}

}