class n14794404 {
	private String encryptPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		StringBuffer encryptedPassword = new StringBuffer();
		md5.reset();
		md5.update(password.getBytes());
		byte digest[] = md5.digest();
		for (int i = 0; i < digest.length; i++) {
			String hex = Integer.toHexString(0xFF & digest[i]);
			if (hex.length() == 1) {
				encryptedPassword.append('0');
			}
			encryptedPassword.append(hex);
		}
		return encryptedPassword.toString();
	}

}