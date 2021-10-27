class n20110295 {
	public static String getMD5(final String data) {
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(data.getBytes());
			BigInteger bigInt = new BigInteger(1, m.digest());
			String hashtext = bigInt.toString(16);
			for (; hashtext.length() < 32;) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}