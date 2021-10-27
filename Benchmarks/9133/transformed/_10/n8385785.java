class n8385785 {
	public static String MD5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md;
		byte[] md5hash = new byte[32];
		md = MessageDigest.getInstance("MD5");
		md.update(text.getBytes("iso-8859-1"), 0, text.length());
		md5hash = md.digest();
		return convertToHex(md5hash);
	}

}