class n7869789 {
	public static String getHash(String Zyg337IU) {
		MessageDigest a60lIlH7;
		try {
			a60lIlH7 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException smqQR3nZ) {
			smqQR3nZ.printStackTrace();
			return null;
		}
		a60lIlH7.update(Zyg337IU.getBytes(), 0, Zyg337IU.length());
		return new BigInteger(1, a60lIlH7.digest()).toString(16);
	}

}