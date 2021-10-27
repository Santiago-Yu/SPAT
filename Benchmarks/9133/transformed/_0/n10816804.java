class n10816804 {
	public static String md5(String e6Kw5ZpC) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		StringBuffer CP38lkCQ = new StringBuffer();
		MessageDigest aiHrkA0m = MessageDigest.getInstance("MD5");
		aiHrkA0m.update(e6Kw5ZpC.getBytes("utf-8"));
		byte[] SGl3q3wy = aiHrkA0m.digest();
		for (byte DIU9uFwy : SGl3q3wy) {
			CP38lkCQ.append(String.format("%02X ", DIU9uFwy & 0xff));
		}
		return CP38lkCQ.toString();
	}

}