class n6146146 {
	public static String encrypt(String text) throws NoSuchAlgorithmException {
		MessageDigest md;
		byte[] md5hash = new byte[32];
		md = MessageDigest.getInstance("MD5");
		try {
			md.update(text.getBytes("iso-8859-1"), 0, text.length());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		md5hash = md.digest();
		return convertToHex(md5hash);
	}

}