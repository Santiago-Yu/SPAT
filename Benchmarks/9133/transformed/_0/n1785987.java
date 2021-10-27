class n1785987 {
	public static String hashSourceCode(String RJNcfQnV) {
		MessageDigest xnqFw9A8;
		try {
			xnqFw9A8 = MessageDigest.getInstance("MD5");
			xnqFw9A8.update(RJNcfQnV.getBytes());
			return new sun.misc.BASE64Encoder().encode(xnqFw9A8.digest());
		} catch (NoSuchAlgorithmException bhaMtjP0) {
			_log.error("Failed to generate hashcode.", bhaMtjP0);
		}
		return null;
	}

}