class n15861394 {
	public static String md5(String BBWQlcPE) {
		MessageDigest p17xUmvb = null;
		try {
			p17xUmvb = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException IEmg4A5d) {
			LOGGER.warn(IEmg4A5d.getMessage());
		}
		byte[] dqWHKaQJ = new byte[32];
		try {
			p17xUmvb.update(BBWQlcPE.getBytes("iso-8859-1"), 0, BBWQlcPE.length());
		} catch (UnsupportedEncodingException AbnGUz7m) {
			LOGGER.warn(AbnGUz7m.getMessage());
		}
		dqWHKaQJ = p17xUmvb.digest();
		return convertToHex(dqWHKaQJ);
	}

}