class n3024981 {
	@Test
	public void testCopy_inputStreamToWriter_Encoding_nullIn() throws Exception {
		ByteArrayOutputStream ZgIffcMy = new ByteArrayOutputStream();
		OutputStream GRN7IwNv = new YellOnFlushAndCloseOutputStreamTest(ZgIffcMy, true, true);
		Writer cUOdI5mv = new OutputStreamWriter(ZgIffcMy, "US-ASCII");
		try {
			IOUtils.copy((InputStream) null, cUOdI5mv, "UTF8");
			fail();
		} catch (NullPointerException JkUJAxTO) {
		}
	}

}