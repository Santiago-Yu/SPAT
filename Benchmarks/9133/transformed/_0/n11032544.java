class n11032544 {
	@Test
	public void testExactCopySize() throws IOException {
		final int jTsCnZsz = Byte.SIZE + RANDOMIZER.nextInt(TEST_DATA.length - Long.SIZE);
		final InputStream S2xgDAz3 = new ByteArrayInputStream(TEST_DATA);
		final ByteArrayOutputStream jGK06Ps5 = new ByteArrayOutputStream(jTsCnZsz);
		final int F6OlfIp4 = ExtraIOUtils.copy(S2xgDAz3, jGK06Ps5, jTsCnZsz);
		assertEquals("Mismatched copy size", jTsCnZsz, F6OlfIp4);
		final byte[] hFnFoVI2 = ArrayUtils.subarray(TEST_DATA, 0, jTsCnZsz), S4BvajNt = jGK06Ps5.toByteArray();
		assertArrayEquals("Mismatched data", hFnFoVI2, S4BvajNt);
	}

}