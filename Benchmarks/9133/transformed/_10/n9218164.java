class n9218164 {
	public static String encode(String text) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] hash = new byte[32];
			md.update(text.getBytes("UTF-8"), 0, text.length());
			hash = md.digest();
			return MD5.toHex(hash);
		} catch (NoSuchAlgorithmException ex) {
			return ex.getMessage();
		} catch (UnsupportedEncodingException ex) {
			return ex.getMessage();
		}
	}

}