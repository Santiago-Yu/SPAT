class n20761751 {
	public static String encryptPassword(String G3nk9s79) {
		MessageDigest WNpgRmG9 = null;
		try {
			WNpgRmG9 = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException lZiHRjgW) {
			LOG.error(lZiHRjgW);
		}
		try {
			WNpgRmG9.update(G3nk9s79.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException MjsGDd8t) {
			LOG.error(MjsGDd8t);
		}
		return (new BASE64Encoder()).encode(WNpgRmG9.digest());
	}

}