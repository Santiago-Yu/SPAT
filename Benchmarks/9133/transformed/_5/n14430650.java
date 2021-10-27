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
		for (i = 0; i < bytes.length; i++)
			if ((bytes[i] >= 0 && bytes[i] <= 15))
				hexBuffer.append(("0") + Integer.toHexString(bytes[i] & 0xFF));
			else
				hexBuffer.append(("") + Integer.toHexString(bytes[i] & 0xFF));
		return hexBuffer.toString();
	}

}