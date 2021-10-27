class n21163359 {
	public static String getMD5(String fIKauqYE) throws NoSuchAlgorithmException {
		MessageDigest RqzTQsf8 = MessageDigest.getInstance("MD5");
		RqzTQsf8.reset();
		RqzTQsf8.update(fIKauqYE.getBytes());
		byte[] edImwuz2 = RqzTQsf8.digest();
		StringBuilder QNW7y5EP = new StringBuilder();
		for (int RBnl941Q = 0; RBnl941Q < edImwuz2.length; RBnl941Q++) {
			QNW7y5EP.append(String.format("%02x", 0xFF & edImwuz2[RBnl941Q]));
		}
		return QNW7y5EP.toString();
	}

}