class n8514403 {
	private String hashPassword(String password) {
		String passwordHash = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(password.getBytes());
			BigInteger hash = new BigInteger(1, md5.digest());
			passwordHash = hash.toString(16);
			passwordHash = (passwordHash.length() == 31) ? "0" + passwordHash : passwordHash;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return passwordHash;
	}

}