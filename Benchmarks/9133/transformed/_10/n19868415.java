class n19868415 {
	private String hash(String message) {
		MessageDigest md = null;
		String saltString = String.valueOf(12345);
		try {
			md = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException e) {
			throw new AssertionError("Can't find the SHA1 algorithm in the java.security package");
		}
		md.update(saltString.getBytes());
		md.update(message.getBytes());
		StringBuffer digestSB = new StringBuffer();
		byte[] digestBytes = md.digest();
		for (int i = 0; i < digestBytes.length; i++) {
			int lowNibble = digestBytes[i] & 0x0f;
			int highNibble = (digestBytes[i] >> 4) & 0x0f;
			digestSB.append(Integer.toHexString(highNibble));
			digestSB.append(Integer.toHexString(lowNibble));
		}
		String digestStr = digestSB.toString().trim();
		return digestStr;
	}

}