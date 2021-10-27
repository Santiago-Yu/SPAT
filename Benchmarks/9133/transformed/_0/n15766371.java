class n15766371 {
	public static String encodeMD5(String ttsQcjHd) throws NoSuchAlgorithmException {
		MessageDigest XrO4xibc = null;
		String bM1jR7JA = null;
		XrO4xibc = MessageDigest.getInstance("MD5");
		XrO4xibc.update(ttsQcjHd.getBytes(), 0, ttsQcjHd.length());
		bM1jR7JA = new BigInteger(1, XrO4xibc.digest()).toString(16);
		if (bM1jR7JA.length() == 31) {
			bM1jR7JA = "0" + bM1jR7JA;
		}
		return bM1jR7JA;
	}

}