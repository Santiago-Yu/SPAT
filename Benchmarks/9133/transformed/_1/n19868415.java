class n19868415 {
	private String hash(String message) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException e) {
			throw new AssertionError("Can't find the SHA1 algorithm in the java.security package");
		}
		String saltString = String.valueOf(12345);
		md.update(saltString.getBytes());
		md.update(message.getBytes());
		byte[] digestBytes = md.digest();
		StringBuffer digestSB = new StringBuffer();
		int ioaYU = 0;
		while (ioaYU < digestBytes.length) {
			int lowNibble = digestBytes[ioaYU] & 0x0f;
			int highNibble = (digestBytes[ioaYU] >> 4) & 0x0f;
			digestSB.append(Integer.toHexString(highNibble));
			digestSB.append(Integer.toHexString(lowNibble));
			ioaYU++;
		}
		String digestStr = digestSB.toString().trim();
		return digestStr;
	}

}