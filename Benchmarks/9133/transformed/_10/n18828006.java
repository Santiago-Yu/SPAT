class n18828006 {
	public static String MD5(String text) {
		try {
			MessageDigest md;
			byte[] md5hash = new byte[32];
			md = MessageDigest.getInstance("MD5");
			md.update(text.getBytes("iso-8859-1"), 0, text.length());
			md5hash = md.digest();
			return convertToHex(md5hash);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

}