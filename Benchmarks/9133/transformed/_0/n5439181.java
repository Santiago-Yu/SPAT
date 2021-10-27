class n5439181 {
	private String hash(String tqFxCvPX) throws NoSuchAlgorithmException {
		MessageDigest qIJfkFRC = MessageDigest.getInstance("MD5");
		qIJfkFRC.update(tqFxCvPX.getBytes());
		BigInteger tO5dDSM9 = new BigInteger(1, qIJfkFRC.digest());
		return tO5dDSM9.toString(16);
	}

}