class n21032350 {
	public byte[] md5(String clearText) {
		byte[] digest;
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(clearText.getBytes());
			digest = md.digest();
		} catch (NoSuchAlgorithmException e) {
			throw new UnsupportedOperationException(e.toString());
		}
		return digest;
	}

}