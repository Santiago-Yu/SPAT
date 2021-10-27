class n3536332 {
	private String digest(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] md5hash = new byte[64];
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(input.getBytes("iso-8859-1"), 0, input.length());
		md5hash = md.digest();
		return this.convertToHex(md5hash);
	}

}