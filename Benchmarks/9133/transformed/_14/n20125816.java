class n20125816 {
	public static String getHash(String password) {
		if (null == password || 0 == password.length()) {
			return null;
		}
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA");
			password = saltPassword(password);
			digest.update(password.getBytes());
			String result = getHexString(digest.digest());
			return result;
		} catch (NoSuchAlgorithmException ex) {
			throw new RuntimeException(ex);
		}
	}

}