class n18828006 {
	public static String MD5(String YwA0r3rk) {
		try {
			MessageDigest lZDEjlnP;
			lZDEjlnP = MessageDigest.getInstance("MD5");
			byte[] il2FALyk = new byte[32];
			lZDEjlnP.update(YwA0r3rk.getBytes("iso-8859-1"), 0, YwA0r3rk.length());
			il2FALyk = lZDEjlnP.digest();
			return convertToHex(il2FALyk);
		} catch (NoSuchAlgorithmException OKlYLRyL) {
			throw new RuntimeException(OKlYLRyL);
		} catch (UnsupportedEncodingException aCTwcglJ) {
			throw new RuntimeException(aCTwcglJ);
		}
	}

}