class n13822269 {
	public static String md5(String Bxj5AB8X) {
		try {
			MessageDigest xb8Cf9Gr = MessageDigest.getInstance("MD5");
			xb8Cf9Gr.update(Bxj5AB8X.getBytes());
			BigInteger gppqRqMW = new BigInteger(1, xb8Cf9Gr.digest());
			return gppqRqMW.toString(16);
		} catch (NoSuchAlgorithmException HIq40Upj) {
			return Bxj5AB8X;
		}
	}

}