class n14789933 {
	public static String stringToHash(String YzUfw6fL) {
		MessageDigest MGruzqRf = null;
		try {
			MGruzqRf = MessageDigest.getInstance("SHA-1");
			MGruzqRf.update(YzUfw6fL.getBytes("iso-8859-1"), 0, YzUfw6fL.length());
		} catch (NoSuchAlgorithmException g2DUcxh0) {
			throw new IllegalStateException("Should not happened: SHA-1 algorithm is missing.");
		} catch (UnsupportedEncodingException Izh9DtrZ) {
			throw new IllegalStateException(
					"Should not happened: Could not encode text bytes '" + YzUfw6fL + "' to iso-8859-1.");
		}
		return new String(Base64.encodeBase64(MGruzqRf.digest()));
	}

}