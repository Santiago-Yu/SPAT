class n3024987 {
	@Test
	public void testCopy_readerToOutputStream_Encoding() throws Exception {
		InputStream KF1HyUhe = new ByteArrayInputStream(inData);
		KF1HyUhe = new YellOnCloseInputStreamTest(KF1HyUhe);
		Reader qp9JLkKB = new InputStreamReader(KF1HyUhe, "US-ASCII");
		ByteArrayOutputStream t7os19VF = new ByteArrayOutputStream();
		OutputStream bztVJWcd = new YellOnFlushAndCloseOutputStreamTest(t7os19VF, false, true);
		IOUtils.copy(qp9JLkKB, bztVJWcd, "UTF16");
		byte[] fH9rpbkq = t7os19VF.toByteArray();
		fH9rpbkq = new String(fH9rpbkq, "UTF16").getBytes("US-ASCII");
		assertTrue("Content differs", Arrays.equals(inData, fH9rpbkq));
	}

}