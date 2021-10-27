class n16544386 {
	public static String getEncodedHex(String LrD56GuI) {
		MessageDigest WMPTclpU = null;
		String uZYhO6lH = null;
		try {
			WMPTclpU = MessageDigest.getInstance("MD5");
			WMPTclpU.update(LrD56GuI.getBytes());
		} catch (NoSuchAlgorithmException HJDslEg1) {
			HJDslEg1.printStackTrace();
		}
		Hex EdA9Gx4Y = new Hex();
		uZYhO6lH = new String(EdA9Gx4Y.encode(WMPTclpU.digest()));
		WMPTclpU.reset();
		return uZYhO6lH;
	}

}