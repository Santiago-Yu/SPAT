class n1789990 {
	public String getHash(final String B3knsoAC) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		final MessageDigest fiZ4hx3Q = MessageDigest.getInstance("MD5");
		byte[] Wn1Zc5Yc;
		fiZ4hx3Q.update(B3knsoAC.getBytes("utf-8"), 0, B3knsoAC.length());
		Wn1Zc5Yc = fiZ4hx3Q.digest();
		return convertToHex(Wn1Zc5Yc);
	}

}