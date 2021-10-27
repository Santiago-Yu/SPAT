class n21413102 {
	private static byte[] getHashBytes(String data, String algorithm) {
		byte[] digest = null;
		MessageDigest md;
		try {
			md = MessageDigest.getInstance(algorithm);
			md.update(data.getBytes("UTF-8"), 0, data.length());
			digest = md.digest();
		} catch (NoSuchAlgorithmException e) {
		} catch (UnsupportedEncodingException e) {
		}
		return digest;
	}

}