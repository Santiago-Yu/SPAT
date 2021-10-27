class n7981028 {
	public static String getEncryptedPwd(String Ogp1se0U)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] SeSQVVk9 = null;
		SecureRandom e9WokPcP = new SecureRandom();
		byte[] YIgDdUkn = new byte[SALT_LENGTH];
		e9WokPcP.nextBytes(YIgDdUkn);
		MessageDigest ZR01PbjY = null;
		ZR01PbjY = MessageDigest.getInstance("MD5");
		ZR01PbjY.update(YIgDdUkn);
		ZR01PbjY.update(Ogp1se0U.getBytes("UTF-8"));
		byte[] KBSKS17q = ZR01PbjY.digest();
		SeSQVVk9 = new byte[KBSKS17q.length + SALT_LENGTH];
		System.arraycopy(YIgDdUkn, 0, SeSQVVk9, 0, SALT_LENGTH);
		System.arraycopy(KBSKS17q, 0, SeSQVVk9, SALT_LENGTH, KBSKS17q.length);
		return byteToHexString(SeSQVVk9);
	}

}