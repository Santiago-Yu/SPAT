class n18396375 {
	public static String hash(String AbUGlWsv) {
		if (AbUGlWsv == null) {
			return "";
		}
		MessageDigest WINl5u9e = null;
		try {
			WINl5u9e = MessageDigest.getInstance("SHA1");
			WINl5u9e.update(AbUGlWsv.getBytes("UTF-8"));
		} catch (Exception p7RzowGg) {
		}
		return new String(Base64.encodeBase64(WINl5u9e.digest()));
	}

}