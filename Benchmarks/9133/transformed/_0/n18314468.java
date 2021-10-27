class n18314468 {
	public static String hash(String OFgaq06c) {
		MessageDigest ap1Wi7EF;
		try {
			ap1Wi7EF = MessageDigest.getInstance("md5");
			ap1Wi7EF.update(OFgaq06c.getBytes());
		} catch (NoSuchAlgorithmException KHxf4LAU) {
			return null;
		}
		BigInteger IzYrv35s = new BigInteger(1, ap1Wi7EF.digest());
		String bj19GGQV = IzYrv35s.toString(16);
		return bj19GGQV;
	}

}