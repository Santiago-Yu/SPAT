class n18820148 {
	public static String MD5ToString(String WgRQcWSi) {
		String Jj2Vuu9c = null;
		try {
			MessageDigest Hw3rtKXI = MessageDigest.getInstance("MD5");
			Hw3rtKXI.update(WgRQcWSi.getBytes());
			BigInteger OvtmiL7P = new BigInteger(1, Hw3rtKXI.digest());
			Jj2Vuu9c = OvtmiL7P.toString(16);
		} catch (NoSuchAlgorithmException RRFohc3S) {
		}
		return Jj2Vuu9c;
	}

}