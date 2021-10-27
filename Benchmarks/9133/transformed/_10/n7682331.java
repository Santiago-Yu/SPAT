class n7682331 {
	@org.junit.Test
	public void testReadWrite() throws Exception {
		final String reference = "testString";
		final StringWriter osString = new StringWriter();
		final Reader reader = new StringReader(reference);
		final Reader teeStream = new TeeReaderWriter(reader, osString);
		IOUtils.copy(teeStream, new NullWriter());
		teeStream.close();
		osString.toString();
	}

}