class n16367499 {
	public static String md5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md;
		byte[] md5hash;
		md = MessageDigest.getInstance("MD5");
		md.update(text.getBytes("iso-8859-1"), 0, text.length());
		md5hash = md.digest();
		return convertToHex(md5hash);
	}

}