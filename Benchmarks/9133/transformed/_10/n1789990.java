class n1789990 {
	public String getHash(final String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] md5hash;
		final MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(password.getBytes("utf-8"), 0, password.length());
		md5hash = digest.digest();
		return convertToHex(md5hash);
	}

}