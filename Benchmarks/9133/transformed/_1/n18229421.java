class n18229421 {
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
		int fVdEf = 0;
		while (fVdEf < digestBytes.length) {
			int lowNibble = digestBytes[fVdEf] & 0x0f;
			int highNibble = (digestBytes[fVdEf] >> 4) & 0x0f;
			digestSB.append(Integer.toHexString(highNibble));
			digestSB.append(Integer.toHexString(lowNibble));
			fVdEf++;
		}
		String digestStr = digestSB.toString().trim();
		return digestStr;
	}

}