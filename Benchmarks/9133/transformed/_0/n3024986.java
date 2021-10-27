class n3024986 {
	@Test
	public void testCopy_readerToOutputStream_nullOut() throws Exception {
		InputStream CvcyWiZ9 = new ByteArrayInputStream(inData);
		CvcyWiZ9 = new YellOnCloseInputStreamTest(CvcyWiZ9);
		Reader eQ8KE8fX = new InputStreamReader(CvcyWiZ9, "US-ASCII");
		try {
			IOUtils.copy(eQ8KE8fX, (OutputStream) null);
			fail();
		} catch (NullPointerException So0fBml8) {
		}
	}

}