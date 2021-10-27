class n15894276 {
	public static String md5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md;
		byte[] md5hash = new byte[32];
		md = MessageDigest.getInstance("MD5");
		md.update(text.getBytes("utf-8"), 0, text.length());
		md5hash = md.digest();
		return convertToHex(md5hash);
	}

}