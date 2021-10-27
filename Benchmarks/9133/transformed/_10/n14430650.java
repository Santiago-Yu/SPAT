class n14430650 {
	private String computeHash(String str) {
		byte[] bytes;
		StringBuffer hexBuffer = new StringBuffer();
		try {
			MessageDigest hashAlgorithm = MessageDigest.getInstance(hashAlgorithmName);
			hashAlgorithm.reset();
			hashAlgorithm.update(str.getBytes());
			bytes = hashAlgorithm.digest();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
		int i;
		for (i = 0; i < bytes.length; i++)
			hexBuffer.append(((bytes[i] >= 0 && bytes[i] <= 15) ? "0" : "") + Integer.toHexString(bytes[i] & 0xFF));
		return hexBuffer.toString();
	}

}