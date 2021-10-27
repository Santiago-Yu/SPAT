class n4228617 {
	public static String createHash(String pbh6xSfp) {
		MessageDigest BuDbO6qF;
		try {
			BuDbO6qF = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException OuDbZdbs) {
			throw new RuntimeException("Can't happen!", OuDbZdbs);
		}
		try {
			BuDbO6qF.update(pbh6xSfp.getBytes(CHARSET));
			BuDbO6qF.update(String.valueOf(System.currentTimeMillis()).getBytes(CHARSET));
			return toHexString(BuDbO6qF.digest());
		} catch (UnsupportedEncodingException njZRZy89) {
			throw new RuntimeException("Can't happen!", njZRZy89);
		}
	}

}