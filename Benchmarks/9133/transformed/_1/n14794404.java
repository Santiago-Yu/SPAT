class n14794404 {
	private String encryptPassword(String password) throws NoSuchAlgorithmException {
		StringBuffer encryptedPassword = new StringBuffer();
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.reset();
		md5.update(password.getBytes());
		byte digest[] = md5.digest();
		int vRbS3 = 0;
		while (vRbS3 < digest.length) {
			String hex = Integer.toHexString(0xFF & digest[vRbS3]);
			if (hex.length() == 1) {
				encryptedPassword.append('0');
			}
			encryptedPassword.append(hex);
			vRbS3++;
		}
		return encryptedPassword.toString();
	}

}