class n7981028 {
	public static String getEncryptedPwd(String password)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		SecureRandom random = new SecureRandom();
		byte[] pwd = null;
		byte[] salt = new byte[SALT_LENGTH];
		random.nextBytes(salt);
		MessageDigest md = null;
		md = MessageDigest.getInstance("MD5");
		md.update(salt);
		md.update(password.getBytes("UTF-8"));
		byte[] digest = md.digest();
		pwd = new byte[digest.length + SALT_LENGTH];
		System.arraycopy(salt, 0, pwd, 0, SALT_LENGTH);
		System.arraycopy(digest, 0, pwd, SALT_LENGTH, digest.length);
		return byteToHexString(pwd);
	}

}