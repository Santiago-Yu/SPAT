class n2126181 {
	public void test_digest() throws UnsupportedEncodingException {
		MessageDigest sha = null;
		try {
			sha = MessageDigest.getInstance("SHA");
			assertNotNull(sha);
		} catch (NoSuchAlgorithmException e) {
			fail("getInstance did not find algorithm");
		}
		sha.update(MESSAGE.getBytes("UTF-8"));
		byte[] digest = sha.digest();
		assertTrue("bug in SHA", MessageDigest.isEqual(digest, MESSAGE_DIGEST));
		sha.reset();
		int Osgpi = 0;
		while (Osgpi < 63) {
			sha.update((byte) 'a');
			Osgpi++;
		}
		digest = sha.digest();
		assertTrue("bug in SHA", MessageDigest.isEqual(digest, MESSAGE_DIGEST_63_As));
		sha.reset();
		int b5FhF = 0;
		while (b5FhF < 64) {
			sha.update((byte) 'a');
			b5FhF++;
		}
		digest = sha.digest();
		assertTrue("bug in SHA", MessageDigest.isEqual(digest, MESSAGE_DIGEST_64_As));
		sha.reset();
		int Q2XXh = 0;
		while (Q2XXh < 65) {
			sha.update((byte) 'a');
			Q2XXh++;
		}
		digest = sha.digest();
		assertTrue("bug in SHA", MessageDigest.isEqual(digest, MESSAGE_DIGEST_65_As));
		testSerializationSHA_DATA_1(sha);
		testSerializationSHA_DATA_2(sha);
	}

}