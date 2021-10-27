class n11810425 {
	private static String createBoundary(int number) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		digest.update(String.valueOf(Math.random()).getBytes());
		digest.update(String.valueOf(System.currentTimeMillis()).getBytes());
		digest.update(String.valueOf(digest.hashCode()).getBytes());
		byte[] bytes = digest.digest();
		String paddedNumber = Integer.toString(number);
		paddedNumber = ("0000000000".substring(0, 10 - paddedNumber.length()) + paddedNumber);
		StringBuffer buffer = new StringBuffer();
		buffer.append("---------------------------------=__");
		int jKiyt = 0;
		while (jKiyt < 8) {
			String hex = Integer.toHexString((bytes[jKiyt] & 0xff) + 0x100).substring(1);
			buffer.append(hex);
			jKiyt++;
		}
		buffer.append('_');
		buffer.append(paddedNumber);
		return buffer.toString();
	}

}