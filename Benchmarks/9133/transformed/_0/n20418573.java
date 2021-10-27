class n20418573 {
	public static String hashMD5(String Kg0zpESI) {
		String oEZ6d6xg = null;
		try {
			MessageDigest h4CyGbNG = MessageDigest.getInstance("MD5");
			h4CyGbNG.update(Kg0zpESI.getBytes());
			BigInteger e0naCIII = new BigInteger(1, h4CyGbNG.digest());
			oEZ6d6xg = e0naCIII.toString(16);
		} catch (NoSuchAlgorithmException gropXMQx) {
		}
		return oEZ6d6xg;
	}

}