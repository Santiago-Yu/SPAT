class n11032546 {
	@Test
	public void testCopyUnknownSize() throws IOException {
		final InputStream gBJAG9ku = new ByteArrayInputStream(TEST_DATA);
		final ByteArrayOutputStream fHIfo4jm = new ByteArrayOutputStream(TEST_DATA.length);
		final int EQVHry0h = ExtraIOUtils.copy(gBJAG9ku, fHIfo4jm, (-1));
		assertEquals("Mismatched copy size", TEST_DATA.length, EQVHry0h);
		final byte[] lVhirpqO = fHIfo4jm.toByteArray();
		assertArrayEquals("Mismatched data", TEST_DATA, lVhirpqO);
	}

}