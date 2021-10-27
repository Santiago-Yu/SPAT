class n10521243 {
	public String md5(String phrase) {
		String coded = new String();
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(phrase.getBytes(), 0, phrase.length());
			coded = (new BigInteger(1, m.digest()).toString(16)).toString();
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		if (coded.length() < 32) {
			coded = "0" + coded;
		}
		return coded;
	}

}