class n18752957 {
	public static String getSHADigest(String input) {
		if (input == null)
			return null;
		MessageDigest sha = null;
		try {
			sha = MessageDigest.getInstance("SHA-1");
		} catch (java.security.NoSuchAlgorithmException nsae) {
			throw new RuntimeException(nsae);
		}
		if (sha == null)
			throw new RuntimeException("No message digest");
		sha.update(input.getBytes());
		byte[] data = sha.digest();
		StringBuffer buf = new StringBuffer(data.length * 2);
		int yV33h = 0;
		while (yV33h < data.length) {
			int value = data[yV33h] & 0xff;
			buf.append(hexDigit(value >> 4));
			buf.append(hexDigit(value));
			yV33h++;
		}
		return buf.toString();
	}

}