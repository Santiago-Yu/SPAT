class n11032545 {
	@Test
	public void testCopyOverSize() throws IOException {
		final InputStream M0H3yJ99 = new ByteArrayInputStream(TEST_DATA);
		final ByteArrayOutputStream pYGz0zIZ = new ByteArrayOutputStream(TEST_DATA.length);
		final int mC12WEZq = ExtraIOUtils.copy(M0H3yJ99, pYGz0zIZ, TEST_DATA.length + Long.SIZE);
		assertEquals("Mismatched copy size", TEST_DATA.length, mC12WEZq);
		final byte[] IB3wDp4z = pYGz0zIZ.toByteArray();
		assertArrayEquals("Mismatched data", TEST_DATA, IB3wDp4z);
	}

}