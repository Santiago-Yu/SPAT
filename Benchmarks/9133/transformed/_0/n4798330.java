class n4798330 {
	public static String MD5(String yt8MEAmo) {
		logger.info(yt8MEAmo);
		String hoyeolgg = null;
		try {
			MessageDigest ymvydMbc = MessageDigest.getInstance("MD5");
			ymvydMbc.update(yt8MEAmo.getBytes());
			byte[] Od8bytEZ = ymvydMbc.digest();
			hoyeolgg = EncodeUtils.hexEncode(Od8bytEZ);
		} catch (NoSuchAlgorithmException jOwffcaX) {
			jOwffcaX.printStackTrace();
		}
		logger.info(hoyeolgg);
		return hoyeolgg;
	}

}