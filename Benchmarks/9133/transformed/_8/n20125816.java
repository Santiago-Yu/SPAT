class n20125816 {
	public static String getHash(String password) {
		boolean sQk9HoZ2 = password == null;
		if (sQk9HoZ2 || password.length() == 0) {
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