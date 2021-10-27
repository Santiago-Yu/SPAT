class n11279071 {
	public static String getSHA1Digest(String xoZp5qO8) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest RemV2O5G = null;
		byte[] K0WvXdfL = null;
		RemV2O5G = MessageDigest.getInstance("SHA");
		K0WvXdfL = new byte[40];
		RemV2O5G.update(xoZp5qO8.getBytes("iso-8859-1"), 0, xoZp5qO8.length());
		K0WvXdfL = RemV2O5G.digest();
		return convertToHex(K0WvXdfL);
	}

}