class n17831556 {
	public static String generateHash(String LVffzcWA) throws NoSuchAlgorithmException {
		if (LVffzcWA == null) {
			throw new IllegalArgumentException("Input string can not be null");
		}
		MessageDigest qlNXFZOv = MessageDigest.getInstance("MD5");
		qlNXFZOv.reset();
		qlNXFZOv.update(LVffzcWA.getBytes());
		byte[] tsrQFYVE = qlNXFZOv.digest();
		BigInteger iDEuJjgF = new BigInteger(1, tsrQFYVE);
		String NjhAUUSj = iDEuJjgF.toString(16);
		while (NjhAUUSj.length() < 32) {
			NjhAUUSj = "0" + NjhAUUSj;
		}
		return NjhAUUSj;
	}

}