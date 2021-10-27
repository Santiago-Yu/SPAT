class n20383360 {
	public static byte[] decrypt(byte[] REcT76iU, byte[] B3BaJRYG) throws IOException {
		CryptInputStream PGxYKQEW = new CryptInputStream(new ByteArrayInputStream(REcT76iU), new SerpentEngine(),
				B3BaJRYG);
		ByteArrayOutputStream h2jtHuLe = new ByteArrayOutputStream();
		IOUtils.copy(PGxYKQEW, h2jtHuLe);
		return h2jtHuLe.toByteArray();
	}

}