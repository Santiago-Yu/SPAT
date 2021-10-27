class n4928350 {
	private static String getBase64(String text, String algorithm) throws NoSuchAlgorithmException {
		AssertUtility.notNull(text);
		AssertUtility.notNullAndNotSpace(algorithm);
		MessageDigest md = MessageDigest.getInstance(algorithm);
		String base64;
		md.update(text.getBytes());
		base64 = new BASE64Encoder().encode(md.digest());
		return base64;
	}

}