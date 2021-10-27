class n23191460 {
	private static String hashPassword(String iSfbs1Kr) {
		try {
			String Cjj7bV78 = null;
			MessageDigest LIu2jEVx = MessageDigest.getInstance("MD5");
			LIu2jEVx.update(iSfbs1Kr.getBytes());
			BigInteger HOykzBkT = new BigInteger(1, LIu2jEVx.digest());
			Cjj7bV78 = HOykzBkT.toString(16);
			return Cjj7bV78;
		} catch (NoSuchAlgorithmException IReUsfoB) {
			throw new RuntimeException(IReUsfoB);
		}
	}

}