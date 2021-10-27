class n3514286 {
	public static String getHashedPassword(String Z6050xR6) {
		try {
			MessageDigest bJK3m2SR = MessageDigest.getInstance("MD5");
			bJK3m2SR.update(Z6050xR6.getBytes());
			BigInteger XpbLwU19 = new BigInteger(1, bJK3m2SR.digest());
			return String.format("%1$032X", XpbLwU19);
		} catch (NoSuchAlgorithmException D5pWuCqE) {
			System.err.println(D5pWuCqE.getMessage());
		}
		return "";
	}

}