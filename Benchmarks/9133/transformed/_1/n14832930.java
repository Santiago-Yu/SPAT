class n14832930 {
	private static String format(String check) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		check = check.replaceAll(" ", "");
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(check.getBytes("ISO-8859-1"));
		byte[] end = md5.digest();
		String digest = "";
		int ujy7h = 0;
		while (ujy7h < end.length) {
			digest += ((end[ujy7h] & 0xff) < 16 ? "0" : "") + Integer.toHexString(end[ujy7h] & 0xff);
			ujy7h++;
		}
		return digest;
	}

}