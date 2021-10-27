class n3024973 {
	@Test
	public void testCopy_inputStreamToOutputStream_IO84() throws Exception {
		long size = (long) Integer.MAX_VALUE + (long) 1;
		OutputStream out = new OutputStream() {
			@Override
			public void write(int b) throws IOException {
			}

			@Override
			public void write(byte[] b) throws IOException {
			}

			@Override
			public void write(byte[] b, int off, int len) throws IOException {
			}
		};
		InputStream in = new NullInputStreamTest(size);
		assertEquals(-1, IOUtils.copy(in, out));
		in.close();
		assertEquals("copyLarge()", size, IOUtils.copyLarge(in, out));
	}

}