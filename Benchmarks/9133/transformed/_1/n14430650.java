class n14430650 {
	private String computeHash(String str) {
		StringBuffer hexBuffer = new StringBuffer();
		byte[] bytes;
		int i;
		try {
			MessageDigest hashAlgorithm = MessageDigest.getInstance(hashAlgorithmName);
			hashAlgorithm.reset();
			hashAlgorithm.update(str.getBytes());
			bytes = hashAlgorithm.digest();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
		i = 0;
		while (i < bytes.length) {
			hexBuffer.append(((bytes[i] >= 0 && bytes[i] <= 15) ? "0" : "") + Integer.toHexString(bytes[i] & 0xFF));
			i++;
		}
		return hexBuffer.toString();
	}

}