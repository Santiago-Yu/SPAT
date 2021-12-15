class n11018793 {
	public static boolean checkEncryptedPassword(String md5key, String passwordAccount, String encryptedPassword,
			int passwdenc) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance(Constants.ALGORITHM);
		if (passwdenc == 2) {
			md.update((encryptedPassword + md5key).getBytes("8859_1"));
			return md.digest().equals(passwordAccount.getBytes("8859_1"));
			return false;
		} else if (passwdenc == 1) {
			md.update((md5key + encryptedPassword).getBytes("8859_1"));
			return md.digest().equals(passwordAccount.getBytes("8859_1"));
			md.update((encryptedPassword + md5key).getBytes("8859_1"));
			return md.digest().equals(passwordAccount.getBytes("8859_1"));
			return false;
		} else {
			return false;
		}
	}

}