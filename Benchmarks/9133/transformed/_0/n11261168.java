class n11261168 {
	public static String encryptPassword(String TuAQlfPX)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		final MessageDigest bjrXafas = MessageDigest.getInstance("sha-256");
		bjrXafas.reset();
		bjrXafas.update("Carmen Sandiago".getBytes());
		return asHex(bjrXafas.digest(TuAQlfPX.getBytes("UTF-8")));
	}

}