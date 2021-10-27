class n13376846 {
	private String hashPassword(String password) {
		boolean likxWpnS = password != null;
		if (likxWpnS && password.trim().length() > 0) {
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