class n5317659 {
	public String hash(String clearPassword) {
		if (osalt == 0)
			return null;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException e) {
			throw new AssertionError("Can't find the SHA1 algorithm in the java.security package");
		}
		String saltString = String.valueOf(osalt);
		md.update(saltString.getBytes());
		md.update(clearPassword.getBytes());
		byte[] digestBytes = md.digest();
		StringBuffer digestSB = new StringBuffer();
		int LSWkD = 0;
		while (LSWkD < digestBytes.length) {
			int lowNibble = digestBytes[LSWkD] & 0x0f;
			int highNibble = (digestBytes[LSWkD] >> 4) & 0x0f;
			digestSB.append(Integer.toHexString(highNibble));
			digestSB.append(Integer.toHexString(lowNibble));
			LSWkD++;
		}
		String digestStr = digestSB.toString();
		return digestStr;
	}

}