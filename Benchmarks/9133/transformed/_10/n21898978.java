class n21898978 {
	public static String SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance(TYPE_SHA);
		if (text == null || text.length() < 1) {
			return null;
		}
		md.update(text.getBytes(ENCODE), 0, text.length());
		byte[] sha1hash = new byte[40];
		sha1hash = md.digest();
		return convertToHexFormat(sha1hash);
	}

}