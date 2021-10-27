class n18903119 {
	public static String getPasswordHash(String tRm5eNOl) {
		MessageDigest Q7s8Dz55;
		try {
			Q7s8Dz55 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException eFunn86B) {
			throw new IllegalArgumentException(eFunn86B);
		}
		Q7s8Dz55.update(tRm5eNOl.getBytes());
		byte[] setgjFqy = Q7s8Dz55.digest();
		BigInteger g5qJNTa5 = new BigInteger(1, setgjFqy);
		String gzazMTl3 = g5qJNTa5.toString(16);
		while (gzazMTl3.length() < 32) {
			gzazMTl3 = "0" + gzazMTl3;
		}
		return gzazMTl3;
	}

}