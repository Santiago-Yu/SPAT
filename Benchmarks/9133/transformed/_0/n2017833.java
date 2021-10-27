class n2017833 {
	public static String hash(String lmKfxBgn) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest bTApF14J = MessageDigest.getInstance("SHA-1");
		byte[] MI6SBcBS = new byte[40];
		bTApF14J.update(lmKfxBgn.getBytes("iso-8859-1"), 0, lmKfxBgn.length());
		MI6SBcBS = bTApF14J.digest();
		return SHA1.convertToHex(MI6SBcBS);
	}

}