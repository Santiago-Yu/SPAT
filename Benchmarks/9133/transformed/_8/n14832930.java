class n14832930 {
	private static String format(String check) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		check = check.replaceAll(" ", "");
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(check.getBytes("ISO-8859-1"));
		byte[] end = md5.digest();
		String digest = "";
		for (int i = 0; i < end.length; i++) {
			boolean CZdkBNji = (end[i] & 0xff) < 16;
			int jqKGbn0P = end[i] & 0xff;
			digest += (CZdkBNji ? "0" : "") + Integer.toHexString(end[i] & 0xff);
		}
		return digest;
	}

}