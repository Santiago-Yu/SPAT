class n3357568 {
	public static String md5(String JNqITdzM) {
		MessageDigest vGU3fPUR = null;
		try {
			vGU3fPUR = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException iDVhKqMk) {
			throw new IllegalStateException("System doesn't support MD5 algorithm.");
		}
		try {
			vGU3fPUR.update(JNqITdzM.getBytes(AlipayConfig.input_charset));
		} catch (UnsupportedEncodingException Z1TDlj1O) {
			throw new IllegalStateException("System doesn't support your  EncodingException.");
		}
		byte[] JPmG1RE3 = vGU3fPUR.digest();
		String sdWFqacE = new String(encodeHex(JPmG1RE3));
		return sdWFqacE;
	}

}