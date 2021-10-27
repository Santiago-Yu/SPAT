class n7574033 {
	public static String generateHashSE(String text)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, DigestException {
		MessageDigest md;
		byte[] hashSHA256 = new byte[32];
		md = MessageDigest.getInstance("SHA-256");
		md.update(text.getBytes("iso-8859-1"), 0, text.length());
		md.digest(hashSHA256, 0, text.length());
		return convertToHex(hashSHA256);
	}

}