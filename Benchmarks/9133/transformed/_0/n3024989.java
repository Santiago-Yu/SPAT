class n3024989 {
	@Test
	public void testCopy_readerToOutputStream_Encoding_nullOut() throws Exception {
		InputStream I05CQUst = new ByteArrayInputStream(inData);
		I05CQUst = new YellOnCloseInputStreamTest(I05CQUst);
		Reader sMmjbeag = new InputStreamReader(I05CQUst, "US-ASCII");
		try {
			IOUtils.copy(sMmjbeag, (OutputStream) null, "UTF16");
			fail();
		} catch (NullPointerException WUQcHK4s) {
		}
	}

}