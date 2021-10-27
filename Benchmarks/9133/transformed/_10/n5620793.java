class n5620793 {
	public static byte[] SHA1byte(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md;
		byte[] sha1hash = new byte[40];
		md = MessageDigest.getInstance("SHA-1");
		md.update(text.getBytes("iso-8859-1"), 0, text.length());
		sha1hash = md.digest();
		return sha1hash;
	}

}