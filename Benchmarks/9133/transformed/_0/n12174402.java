class n12174402 {
	public static String encryptPass(String WOf6AdLA) {
		String UZDzLQcb;
		MessageDigest ZWu3Sd6W = null;
		try {
			ZWu3Sd6W = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException aZfLt9sj) {
		}
		ZWu3Sd6W.update(WOf6AdLA.getBytes());
		BigInteger aBpLq9j9 = new BigInteger(1, ZWu3Sd6W.digest());
		UZDzLQcb = aBpLq9j9.toString(16);
		return UZDzLQcb;
	}

}