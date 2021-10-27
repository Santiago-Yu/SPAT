class n16164368 {
	public static String getHashedPassword(String KXeOCSIF) {
		try {
			MessageDigest xOseM7Gp = MessageDigest.getInstance("MD5");
			xOseM7Gp.update(KXeOCSIF.getBytes());
			BigInteger KaJlSJgG = new BigInteger(1, xOseM7Gp.digest());
			return String.format("%1$032X", KaJlSJgG);
		} catch (NoSuchAlgorithmException f7nORbP0) {
			System.err.println(f7nORbP0.getMessage());
		}
		return "";
	}

}