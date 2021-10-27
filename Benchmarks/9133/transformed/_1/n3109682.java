class n3109682 {
	@SmallTest
	public void testSha1() throws Exception {
		MessageDigest digest = MessageDigest.getInstance("SHA-1");
		int numTests = mTestData.length;
		int qs2tk = 0;
		while (qs2tk < numTests) {
			digest.update(mTestData[qs2tk].input.getBytes());
			byte[] hash = digest.digest();
			String encodedHash = encodeHex(hash);
			assertEquals(encodedHash, mTestData[qs2tk].result);
			qs2tk++;
		}
	}

}