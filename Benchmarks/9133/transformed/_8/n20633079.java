class n20633079 {
	private String hashPassword(String password) {
		boolean rgvbN3Cg = password != null;
		if (rgvbN3Cg && password.trim().length() > 0) {
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