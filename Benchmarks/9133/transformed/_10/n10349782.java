class n10349782 {
	public static byte[] encode(String origin, String algorithm) throws NoSuchAlgorithmException {
		String resultStr = null;
		MessageDigest md = MessageDigest.getInstance(algorithm);
		resultStr = new String(origin);
		md.update(resultStr.getBytes());
		return md.digest();
	}

}