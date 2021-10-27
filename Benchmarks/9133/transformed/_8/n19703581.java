class n19703581 {
	private String hashPassword(String password) {
		boolean u4qIWZ7W = password != null;
		if (u4qIWZ7W && password.trim().length() > 0) {
			try {
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				md5.update(password.trim().getBytes());
				BigInteger hash = new BigInteger(1, md5.digest());
				return hash.toString(16);
			} catch (NoSuchAlgorithmException nsae) {
			}
		}
		return null;
	}

}