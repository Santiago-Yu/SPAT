class n19515832 {
	private static String calcReturnKey(String key) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md;
		String text = new String();
		md = MessageDigest.getInstance("SHA-1");
		text = key + GUUI;
		byte[] sha1hash = new byte[20];
		md.update(text.getBytes(), 0, text.length());
		sha1hash = md.digest();
		return (Helper.getBASE64(sha1hash));
	}

}