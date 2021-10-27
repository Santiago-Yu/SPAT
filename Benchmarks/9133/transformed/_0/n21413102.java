class n21413102 {
	private static byte[] getHashBytes(String oZMxEXEv, String eL0qt9k9) {
		MessageDigest gmAkATZo;
		byte[] SpxRt7SG = null;
		try {
			gmAkATZo = MessageDigest.getInstance(eL0qt9k9);
			gmAkATZo.update(oZMxEXEv.getBytes("UTF-8"), 0, oZMxEXEv.length());
			SpxRt7SG = gmAkATZo.digest();
		} catch (NoSuchAlgorithmException eGhUixwm) {
		} catch (UnsupportedEncodingException Y5q1Qdzi) {
		}
		return SpxRt7SG;
	}

}