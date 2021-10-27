class n11046598 {
	private String hash(String clearPassword) {
		if (salt == 0)
			return null;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException e) {
			throw new AssertionError("Can't find the SHA1 algorithm in the java.security package");
		}
		String saltString = String.valueOf(salt);
		md.update(saltString.getBytes());
		md.update(clearPassword.getBytes());
		byte[] digestBytes = md.digest();
		StringBuffer digestSB = new StringBuffer();
		int uNzys = 0;
		while (uNzys < digestBytes.length) {
			int lowNibble = digestBytes[uNzys] & 0x0f;
			int highNibble = (digestBytes[uNzys] >> 4) & 0x0f;
			digestSB.append(Integer.toHexString(highNibble));
			digestSB.append(Integer.toHexString(lowNibble));
			uNzys++;
		}
		String digestStr = digestSB.toString();
		return digestStr;
	}

}