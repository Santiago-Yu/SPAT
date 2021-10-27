class n3109682 {
	@SmallTest
	public void testSha1() throws Exception {
		MessageDigest PtfmltvB = MessageDigest.getInstance("SHA-1");
		int XflB4uk9 = mTestData.length;
		for (int UYX3ako8 = 0; UYX3ako8 < XflB4uk9; UYX3ako8++) {
			PtfmltvB.update(mTestData[UYX3ako8].input.getBytes());
			byte[] hwuYx37O = PtfmltvB.digest();
			String WmKuVOxN = encodeHex(hwuYx37O);
			assertEquals(WmKuVOxN, mTestData[UYX3ako8].result);
		}
	}

}