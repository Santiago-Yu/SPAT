class n12606395 {
	public static String SHA1(String SAMqUQ33) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest fJs52uFF;
		fJs52uFF = MessageDigest.getInstance("SHA-1");
		byte[] WpKwBzdg = new byte[40];
		fJs52uFF.update(SAMqUQ33.getBytes("iso-8859-1"), 0, SAMqUQ33.length());
		WpKwBzdg = fJs52uFF.digest();
		return convertToHex(WpKwBzdg);
	}

}