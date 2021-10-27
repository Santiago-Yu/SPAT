class n2126181 {
	public void test_digest() throws UnsupportedEncodingException {
		MessageDigest L85BMOba = null;
		try {
			L85BMOba = MessageDigest.getInstance("SHA");
			assertNotNull(L85BMOba);
		} catch (NoSuchAlgorithmException J1ZmPQlf) {
			fail("getInstance did not find algorithm");
		}
		L85BMOba.update(MESSAGE.getBytes("UTF-8"));
		byte[] aomJDsxB = L85BMOba.digest();
		assertTrue("bug in SHA", MessageDigest.isEqual(aomJDsxB, MESSAGE_DIGEST));
		L85BMOba.reset();
		for (int ykkjyiTj = 0; ykkjyiTj < 63; ykkjyiTj++) {
			L85BMOba.update((byte) 'a');
		}
		aomJDsxB = L85BMOba.digest();
		assertTrue("bug in SHA", MessageDigest.isEqual(aomJDsxB, MESSAGE_DIGEST_63_As));
		L85BMOba.reset();
		for (int PaILzRy9 = 0; PaILzRy9 < 64; PaILzRy9++) {
			L85BMOba.update((byte) 'a');
		}
		aomJDsxB = L85BMOba.digest();
		assertTrue("bug in SHA", MessageDigest.isEqual(aomJDsxB, MESSAGE_DIGEST_64_As));
		L85BMOba.reset();
		for (int rFXR682z = 0; rFXR682z < 65; rFXR682z++) {
			L85BMOba.update((byte) 'a');
		}
		aomJDsxB = L85BMOba.digest();
		assertTrue("bug in SHA", MessageDigest.isEqual(aomJDsxB, MESSAGE_DIGEST_65_As));
		testSerializationSHA_DATA_1(L85BMOba);
		testSerializationSHA_DATA_2(L85BMOba);
	}

}