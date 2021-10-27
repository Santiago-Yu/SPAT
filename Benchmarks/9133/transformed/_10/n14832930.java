class n14832930 {
	private static String format(String check) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		check = check.replaceAll(" ", "");
		md5.update(check.getBytes("ISO-8859-1"));
		String digest = "";
		byte[] end = md5.digest();
		for (int i = 0; i < end.length; i++) {
			digest += ((end[i] & 0xff) < 16 ? "0" : "") + Integer.toHexString(end[i] & 0xff);
		}
		return digest;
	}

}