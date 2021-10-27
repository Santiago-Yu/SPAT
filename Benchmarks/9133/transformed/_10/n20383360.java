class n20383360 {
	public static byte[] decrypt(byte[] ciphertext, byte[] key) throws IOException {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		CryptInputStream in = new CryptInputStream(new ByteArrayInputStream(ciphertext), new SerpentEngine(), key);
		IOUtils.copy(in, bout);
		return bout.toByteArray();
	}

}