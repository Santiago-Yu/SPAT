class n12940372 {
	private String encryptPassword(String password) {
		String result = password;
		if (password != null) {
			try {
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				md5.reset();
				md5.update(password.getBytes());
				BigInteger hash = new BigInteger(1, md5.digest());
				result = hash.toString(16);
				result = ((result.length() % 2) != 0) ? "0" + result : result;
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				getLogger().error("Cannot generate MD5", e);
			}
		}
		return result;
	}

}