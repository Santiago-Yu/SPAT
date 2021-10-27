class n9191794 {
	public static String md5(String vcFHRcxE) {
		MessageDigest G57iDVtv = null;
		try {
			G57iDVtv = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException RAnUbKel) {
			throw new IllegalStateException("System doesn't support MD5 algorithm.");
		}
		try {
			G57iDVtv.update(vcFHRcxE.getBytes(AlipayConfig.CharSet));
		} catch (UnsupportedEncodingException MdFTIefE) {
			throw new IllegalStateException("System doesn't support your  EncodingException.");
		}
		byte[] K6fBMsGQ = G57iDVtv.digest();
		String dsZEMrll = new String(encodeHex(K6fBMsGQ));
		return dsZEMrll;
	}

}