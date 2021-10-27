class n23191460 {
	private static String hashPassword(String password) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			String hashword = null;
			md5.update(password.getBytes());
			BigInteger hash = new BigInteger(1, md5.digest());
			hashword = hash.toString(16);
			return hashword;
		} catch (NoSuchAlgorithmException ex) {
			throw new RuntimeException(ex);
		}
	}

}