class n14960576 {
	public static String encrypt(String JruhvDqh) {
		MessageDigest tx5Flqjf = null;
		try {
			tx5Flqjf = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException HiVY2zeS) {
			throw new WebDocRuntimeException(HiVY2zeS);
		}
		tx5Flqjf.update(JruhvDqh.getBytes());
		BigInteger JOICimEg = new BigInteger(1, tx5Flqjf.digest());
		return JOICimEg.toString(HEX);
	}

}