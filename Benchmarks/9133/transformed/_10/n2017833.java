class n2017833 {
	public static String hash(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] sha1hash = new byte[40];
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(text.getBytes("iso-8859-1"), 0, text.length());
		sha1hash = md.digest();
		return SHA1.convertToHex(sha1hash);
	}

}