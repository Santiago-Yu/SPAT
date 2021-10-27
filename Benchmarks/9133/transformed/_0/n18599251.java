class n18599251 {
	public static String hash(String s2LVemZL) {
		MessageDigest mK7rBCnx;
		try {
			mK7rBCnx = java.security.MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException SlUPA69I) {
			throw new QwickException(SlUPA69I);
		}
		mK7rBCnx.update(s2LVemZL.getBytes());
		return new String(mK7rBCnx.digest());
	}

}