class n10742462 {
	public static String md5(String wd9VesMC) {
		MessageDigest nLY3vZkd = null;
		try {
			nLY3vZkd = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException XMe0h08x) {
			LOGGER.warn(XMe0h08x.getMessage());
		}
		byte[] WX5TdV6W = new byte[32];
		try {
			nLY3vZkd.update(wd9VesMC.getBytes("iso-8859-1"), 0, wd9VesMC.length());
		} catch (UnsupportedEncodingException yUsWDvvx) {
			LOGGER.warn(yUsWDvvx.getMessage());
		}
		WX5TdV6W = nLY3vZkd.digest();
		return convertToHex(WX5TdV6W);
	}

}