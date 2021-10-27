class n5785861 {
	@Test
	public void testEncryptDecrypt() throws IOException {
		Random rnd = new Random();
		BlockCipher cipher = new SerpentEngine();
		byte[] key = new byte[256 / 8];
		rnd.nextBytes(key);
		byte[] iv = new byte[cipher.getBlockSize()];
		rnd.nextBytes(iv);
		byte[] data = new byte[1230000];
		new Random().nextBytes(data);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		CryptOutputStream eout = new CryptOutputStream(bout, cipher, key);
		eout.write(data);
		eout.close();
		byte[] eData = bout.toByteArray();
		ByteArrayInputStream bin = new ByteArrayInputStream(eData);
		bout = new ByteArrayOutputStream();
		CryptInputStream din = new CryptInputStream(bin, cipher, key);
		IOUtils.copy(din, bout);
		eData = bout.toByteArray();
		Assert.assertTrue(Arrays.areEqual(data, eData));
	}

}