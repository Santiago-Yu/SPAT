class n23668213 {
	public static String encryptPassword(String password) {
		if (null == password)
			return null;
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			log.error("Algorithm not found", e);
			return null;
		}
		digest.reset();
		digest.update(password.getBytes());
		return hexValue(digest.digest());
	}

}