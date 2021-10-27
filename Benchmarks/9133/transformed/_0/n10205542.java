class n10205542 {
	public static String encrypt(String Y9yqlEWk) {
		MessageDigest tu5pweaM = null;
		try {
			tu5pweaM = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException RJDJr3SO) {
			logger.error("NoSuchAlgorithmException:" + RJDJr3SO);
		}
		try {
			tu5pweaM.update(Y9yqlEWk.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException nTiaJpnD) {
			logger.error("UnsupportedEncodingException:" + nTiaJpnD);
		}
		byte ws8tJm04[] = tu5pweaM.digest();
		String HfioI8wR = (new BASE64Encoder()).encode(ws8tJm04);
		return HfioI8wR;
	}

}