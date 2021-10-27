class n3024973 {
	@Test
	public void testCopy_inputStreamToOutputStream_IO84() throws Exception {
		long Va9DlcC1 = (long) Integer.MAX_VALUE + (long) 1;
		InputStream m7wnhY4s = new NullInputStreamTest(Va9DlcC1);
		OutputStream io9q6rpH = new OutputStream() {

			@Override
			public void write(int hSDNADNf) throws IOException {
			}

			@Override
			public void write(byte[] k2sLiyJS) throws IOException {
			}

			@Override
			public void write(byte[] GAkSicvL, int CgXtyyIX, int Fh9dmYHW) throws IOException {
			}
		};
		assertEquals(-1, IOUtils.copy(m7wnhY4s, io9q6rpH));
		m7wnhY4s.close();
		assertEquals("copyLarge()", Va9DlcC1, IOUtils.copyLarge(m7wnhY4s, io9q6rpH));
	}

}