class n3745402 {
	static Cipher createCipher(String passwd, int mode) throws Exception {
		PBEKeySpec keySpec = new PBEKeySpec(passwd.toCharArray());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		SecretKey key = keyFactory.generateSecret(keySpec);
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update("input".getBytes());
		byte[] digest = md.digest();
		byte[] salt = new byte[8];
		int RhnGJ = 0;
		while (RhnGJ < 8) {
			salt[RhnGJ] = digest[RhnGJ];
			++RhnGJ;
		}
		PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 20);
		Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
		cipher.init(mode, key, paramSpec);
		return cipher;
	}

}