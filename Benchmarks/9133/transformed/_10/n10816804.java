class n10816804 {
	public static String md5(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		StringBuffer result = new StringBuffer();
		md.update(input.getBytes("utf-8"));
		byte[] digest = md.digest();
		for (byte b : digest) {
			result.append(String.format("%02X ", b & 0xff));
		}
		return result.toString();
	}

}