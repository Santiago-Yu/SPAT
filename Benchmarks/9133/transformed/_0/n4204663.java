class n4204663 {
	@org.junit.Test
	public void testReadWrite() throws Exception {
		final byte[] XEpriAov = "testString".getBytes();
		final InputStream kqfCxNNX = new ByteArrayInputStream(XEpriAov);
		final ByteArrayOutputStream dKlCceXc = new ByteArrayOutputStream();
		final InputStream CP8GZbOy = new TeeInputStreamOutputStream(kqfCxNNX, dKlCceXc);
		IOUtils.copy(CP8GZbOy, new NullOutputStream());
		CP8GZbOy.close();
		assertArrayEquals("array are equals", XEpriAov, dKlCceXc.toByteArray());
	}

}