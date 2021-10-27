class n3024993 {
	@Test
	public void testCopy_readerToWriter_nullOut() throws Exception {
		InputStream XEJazbtD = new ByteArrayInputStream(inData);
		XEJazbtD = new YellOnCloseInputStreamTest(XEJazbtD);
		Reader apT70fze = new InputStreamReader(XEJazbtD, "US-ASCII");
		try {
			IOUtils.copy(apT70fze, (Writer) null);
			fail();
		} catch (NullPointerException pePsfIGO) {
		}
	}

}