class n7346958 {
	public static String SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md;
		byte[] sha1hash = new byte[40];
		md = MessageDigest.getInstance("SHA-1");
		md.update(text.getBytes("iso-8859-1"), 0, text.length());
		sha1hash = md.digest();
		return convertToHex(sha1hash);
	}

}