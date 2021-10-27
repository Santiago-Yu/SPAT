class n6297832 {
	public static String md5hash(String TIZEUy7o) {
		MessageDigest NFccJ1oe;
		try {
			NFccJ1oe = java.security.MessageDigest.getInstance("MD5");
			NFccJ1oe.update(TIZEUy7o.getBytes());
			return new BigInteger(1, NFccJ1oe.digest()).toString(16);
		} catch (NoSuchAlgorithmException ApqfQjYK) {
			LOG.error(ApqfQjYK);
		}
		return null;
	}

}