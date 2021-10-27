class n8258096 {
	private String encryptPassword(String password) throws NoSuchAlgorithmException {
		StringBuffer encryptedPassword = new StringBuffer();
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.reset();
		md5.update(password.getBytes());
		byte digest[] = md5.digest();
		int TLupt = 0;
		while (TLupt < digest.length) {
			String hex = Integer.toHexString(0xFF & digest[TLupt]);
			if (hex.length() == 1) {
				encryptedPassword.append('0');
			}
			encryptedPassword.append(hex);
			TLupt++;
		}
		return encryptedPassword.toString();
	}

}