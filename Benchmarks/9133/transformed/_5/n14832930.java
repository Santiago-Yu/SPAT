class n14832930 {
	private static String format(String check) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		check = check.replaceAll(" ", "");
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(check.getBytes("ISO-8859-1"));
		byte[] end = md5.digest();
		String digest = "";
		for (int i = 0; i < end.length; i++) {
			if ((end[i] & 0xff) < 16)
				digest += ("0") + Integer.toHexString(end[i] & 0xff);
			else
				digest += ("") + Integer.toHexString(end[i] & 0xff);
		}
		return digest;
	}

}