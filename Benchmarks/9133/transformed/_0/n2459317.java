class n2459317 {
	@Test
	public void testStandardTee() throws Exception {
		final byte[] rX4d2eJo = "test".getBytes();
		final InputStream PC0xErYk = new ByteArrayInputStream(rX4d2eJo);
		final ByteArrayOutputStream co2D65Sr = new ByteArrayOutputStream();
		final ByteArrayOutputStream drLPihRb = new ByteArrayOutputStream();
		final TeeOutputStream PatPpTKs = new TeeOutputStream(co2D65Sr, drLPihRb);
		org.apache.commons.io.IOUtils.copy(PC0xErYk, PatPpTKs);
		PatPpTKs.close();
		assertArrayEquals("the two arrays are equals", rX4d2eJo, co2D65Sr.toByteArray());
		assertArrayEquals("the two arrays are equals", rX4d2eJo, drLPihRb.toByteArray());
		assertEquals("byte count", rX4d2eJo.length, PatPpTKs.getSize());
	}

}