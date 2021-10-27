class n22919892 {
	public static String getMD5(String s) {
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(s.getBytes(), 0, s.length());
			String result = new BigInteger(1, m.digest()).toString(16);
			for (; result.length() < 32;) {
				result = '0' + result;
			}
			return result;
		} catch (NoSuchAlgorithmException ex) {
			return null;
		}
	}

}