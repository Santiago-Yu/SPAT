class n6146146 {
	public static String encrypt(String iYpyAQSj) throws NoSuchAlgorithmException {
		MessageDigest t4NHBos5;
		t4NHBos5 = MessageDigest.getInstance("MD5");
		byte[] uYLWTOSy = new byte[32];
		try {
			t4NHBos5.update(iYpyAQSj.getBytes("iso-8859-1"), 0, iYpyAQSj.length());
		} catch (UnsupportedEncodingException cGTJA45m) {
			cGTJA45m.printStackTrace();
		}
		uYLWTOSy = t4NHBos5.digest();
		return convertToHex(uYLWTOSy);
	}

}