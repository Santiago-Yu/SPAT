class n18828007 {
	public static String SHA1(String xjvkc1bg) {
		try {
			MessageDigest A6NyB7Wz;
			A6NyB7Wz = MessageDigest.getInstance("SHA-1");
			byte[] l8K4o5sw = new byte[32];
			A6NyB7Wz.update(xjvkc1bg.getBytes("iso-8859-1"), 0, xjvkc1bg.length());
			l8K4o5sw = A6NyB7Wz.digest();
			return convertToHex(l8K4o5sw);
		} catch (NoSuchAlgorithmException EhPGIFZu) {
			throw new RuntimeException(EhPGIFZu);
		} catch (UnsupportedEncodingException afkZ9Sm1) {
			throw new RuntimeException(afkZ9Sm1);
		}
	}

}