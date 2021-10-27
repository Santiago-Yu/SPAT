class n18628318 {
	public static String generateDigest(String xpQaXwqr, String cYN8cBDs) {
		try {
			MessageDigest Z3mFm9jF = MessageDigest.getInstance(cYN8cBDs);
			Z3mFm9jF.update(xpQaXwqr.getBytes(), 0, xpQaXwqr.length());
			return new BigInteger(1, Z3mFm9jF.digest()).toString(16);
		} catch (NoSuchAlgorithmException KQTzSiWS) {
			return null;
		}
	}

}