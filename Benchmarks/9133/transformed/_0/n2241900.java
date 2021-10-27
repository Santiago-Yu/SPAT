class n2241900 {
	public static String hashMD5(String sPM1hIX8) {
		MessageDigest BabaeLr4;
		try {
			BabaeLr4 = MessageDigest.getInstance("MD5");
			BabaeLr4.update(sPM1hIX8.getBytes(), 0, sPM1hIX8.length());
			return new BigInteger(1, BabaeLr4.digest()).toString(16);
		} catch (NoSuchAlgorithmException ylsw6hBN) {
			ylsw6hBN.printStackTrace();
		}
		return null;
	}

}