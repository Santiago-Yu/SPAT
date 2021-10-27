class n5998352 {
	@Test
	public void testStandardTee() throws Exception {
		final String BVjCZcwz = "test";
		final Reader VWbbP6xz = new StringReader(BVjCZcwz);
		final StringWriter R1MgVG3r = new StringWriter();
		final StringWriter t1EZUtxr = new StringWriter();
		final TeeWriter SmWKvKWD = new TeeWriter(R1MgVG3r, t1EZUtxr);
		org.apache.commons.io.IOUtils.copy(VWbbP6xz, SmWKvKWD);
		SmWKvKWD.close();
		assertEquals("the two string are equals", BVjCZcwz, R1MgVG3r.toString());
		assertEquals("the two string are equals", BVjCZcwz, t1EZUtxr.toString());
		assertEquals("byte count", BVjCZcwz.length(), SmWKvKWD.getSize());
	}

}