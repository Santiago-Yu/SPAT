class n8320377 {
	private static String md5(String AVPgOBmB) {
		try {
			MessageDigest AsZuRJTz = MessageDigest.getInstance("MD5");
			AsZuRJTz.update(AVPgOBmB.getBytes(), 0, AVPgOBmB.length());
			return new BigInteger(1, AsZuRJTz.digest()).toString(16);
		} catch (NoSuchAlgorithmException mV5QeCku) {
			mV5QeCku.printStackTrace();
			throw new Error();
		}
	}

}