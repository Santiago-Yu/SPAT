class n21694489 {
	public static String mdFive(String string) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] array = new byte[32];
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(string.getBytes("iso-8859-1"), 0, string.length());
		array = md.digest();
		return convertToHex(array);
	}

}