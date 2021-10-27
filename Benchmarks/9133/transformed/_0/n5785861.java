class n5785861 {
	@Test
	public void testEncryptDecrypt() throws IOException {
		BlockCipher BVHvbLDo = new SerpentEngine();
		Random vxOJEmFK = new Random();
		byte[] JtN2qHC4 = new byte[256 / 8];
		vxOJEmFK.nextBytes(JtN2qHC4);
		byte[] iCrcN8tY = new byte[BVHvbLDo.getBlockSize()];
		vxOJEmFK.nextBytes(iCrcN8tY);
		byte[] CfpZIL7Z = new byte[1230000];
		new Random().nextBytes(CfpZIL7Z);
		ByteArrayOutputStream kzWxqevt = new ByteArrayOutputStream();
		CryptOutputStream WbC9xOCK = new CryptOutputStream(kzWxqevt, BVHvbLDo, JtN2qHC4);
		WbC9xOCK.write(CfpZIL7Z);
		WbC9xOCK.close();
		byte[] GIAQCCHA = kzWxqevt.toByteArray();
		ByteArrayInputStream pVKPaDET = new ByteArrayInputStream(GIAQCCHA);
		CryptInputStream LjU8yEeW = new CryptInputStream(pVKPaDET, BVHvbLDo, JtN2qHC4);
		kzWxqevt = new ByteArrayOutputStream();
		IOUtils.copy(LjU8yEeW, kzWxqevt);
		GIAQCCHA = kzWxqevt.toByteArray();
		Assert.assertTrue(Arrays.areEqual(CfpZIL7Z, GIAQCCHA));
	}

}