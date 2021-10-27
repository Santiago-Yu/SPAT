class n1050422 {
	public static String getSHA1Digest(String inputStr) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] sha1hash = null;
		MessageDigest md = null;
		sha1hash = new byte[40];
		md = MessageDigest.getInstance("SHA");
		md.update(inputStr.getBytes("iso-8859-1"), 0, inputStr.length());
		sha1hash = md.digest();
		return convertToHex(sha1hash);
	}

}