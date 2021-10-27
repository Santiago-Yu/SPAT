class n11504871 {
	public static String encrypt(String qQr6vcd3) throws NoSuchAlgorithmException {
		java.security.MessageDigest X5idXNZT = null;
		X5idXNZT = java.security.MessageDigest.getInstance("MD5");
		X5idXNZT.reset();
		X5idXNZT.update(qQr6vcd3.getBytes());
		byte[] ifCoMQm2 = X5idXNZT.digest();
		return getString(ifCoMQm2).toLowerCase();
	}

}