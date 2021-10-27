class n5317659 {
	public String hash(String clearPassword) {
		MessageDigest md = null;
		if (osalt == 0)
			return null;
		try {
			md = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException e) {
			throw new AssertionError("Can't find the SHA1 algorithm in the java.security package");
		}
		String saltString = String.valueOf(osalt);
		md.update(saltString.getBytes());
		md.update(clearPassword.getBytes());
		StringBuffer digestSB = new StringBuffer();
		byte[] digestBytes = md.digest();
		for (int i = 0; i < digestBytes.length; i++) {
			int lowNibble = digestBytes[i] & 0x0f;
			int highNibble = (digestBytes[i] >> 4) & 0x0f;
			digestSB.append(Integer.toHexString(highNibble));
			digestSB.append(Integer.toHexString(lowNibble));
		}
		String digestStr = digestSB.toString();
		return digestStr;
	}

}