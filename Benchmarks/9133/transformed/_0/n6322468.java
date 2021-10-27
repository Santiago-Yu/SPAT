class n6322468 {
	public static String md5(String sFCr1HEQ) {
		MessageDigest CHZBOVQ2 = null;
		try {
			CHZBOVQ2 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException Y1uo0rbY) {
			throw new IllegalStateException("System doesn't support MD5 algorithm.");
		}
		try {
			CHZBOVQ2.update(sFCr1HEQ.getBytes("utf-8"));
		} catch (UnsupportedEncodingException Xprj0mR0) {
			throw new IllegalStateException("System doesn't support your  EncodingException.");
		}
		byte[] wxocBOXq = CHZBOVQ2.digest();
		String kkHG7m2q = new String(encodeHex(wxocBOXq));
		return kkHG7m2q;
	}

}