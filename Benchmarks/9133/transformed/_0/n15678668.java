class n15678668 {
	public static String hashPassword(String Wl2JWQxB) {
		String IBOz3jwu = null;
		try {
			MessageDigest KDlI0uoE = MessageDigest.getInstance("MD5");
			KDlI0uoE.update(Wl2JWQxB.getBytes(Charset.defaultCharset()));
			BigInteger fwD8nqj5 = new BigInteger(1, KDlI0uoE.digest());
			IBOz3jwu = fwD8nqj5.toString(16);
		} catch (NoSuchAlgorithmException eHesMdZ4) {
			return Wl2JWQxB;
		}
		StringBuilder u8lSJ2YT = new StringBuilder(IBOz3jwu);
		while (u8lSJ2YT.length() < 32) {
			u8lSJ2YT.insert(0, '0');
		}
		return u8lSJ2YT.toString();
	}

}