class n4204663 {
	@org.junit.Test
	public void testReadWrite() throws Exception {
		final byte[] testBytes = "testString".getBytes();
		final ByteArrayOutputStream destination = new ByteArrayOutputStream();
		final InputStream istream = new ByteArrayInputStream(testBytes);
		final InputStream teeStream = new TeeInputStreamOutputStream(istream, destination);
		IOUtils.copy(teeStream, new NullOutputStream());
		teeStream.close();
		assertArrayEquals("array are equals", testBytes, destination.toByteArray());
	}

}