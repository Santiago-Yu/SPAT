class n3745402 {
	static Cipher createCipher(String passwd, int mode) throws Exception {
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		PBEKeySpec keySpec = new PBEKeySpec(passwd.toCharArray());
		SecretKey key = keyFactory.generateSecret(keySpec);
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update("input".getBytes());
		byte[] salt = new byte[8];
		byte[] digest = md.digest();
		for (int i = 0; i < 8; ++i)
			salt[i] = digest[i];
		Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
		PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 20);
		cipher.init(mode, key, paramSpec);
		return cipher;
	}

}