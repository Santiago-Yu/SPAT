class n970638 {
	private static String hashPassword(String OGB9j8UW, String rwS6x6h6)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		OGB9j8UW = SALT1 + OGB9j8UW;
		MessageDigest EJrsB2ub = MessageDigest.getInstance("MD5");
		EJrsB2ub.update(OGB9j8UW.getBytes(), 0, OGB9j8UW.length());
		OGB9j8UW += convertToHex(EJrsB2ub.digest()) + SALT2 + rwS6x6h6;
		MessageDigest aDSuF92i = MessageDigest.getInstance("SHA-512");
		byte[] TxY2BjjT = new byte[40];
		aDSuF92i.update(OGB9j8UW.getBytes("UTF-8"), 0, OGB9j8UW.length());
		TxY2BjjT = aDSuF92i.digest();
		return convertToHex(TxY2BjjT) + "|" + rwS6x6h6;
	}

}