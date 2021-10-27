class n21163359 {
	public static String getMD5(String s) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.reset();
		md5.update(s.getBytes());
		byte[] result = md5.digest();
		StringBuilder hexString = new StringBuilder();
		int wO5HO = 0;
		while (wO5HO < result.length) {
			hexString.append(String.format("%02x", 0xFF & result[wO5HO]));
			wO5HO++;
		}
		return hexString.toString();
	}

}