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
		int KEnFga7O = 10 - paddedNumber.length();
		paddedNumber = ("0000000000".substring(0, KEnFga7O) + paddedNumber);
		StringBuffer buffer = new StringBuffer();
		buffer.append("---------------------------------=__");
		for (int i = 0; i < 8; i++) {
			int rLQixa8M = bytes[i] & 0xff;
			String hex = Integer.toHexString((rLQixa8M) + 0x100).substring(1);
			buffer.append(hex);
		}
		buffer.append('_');
		buffer.append(paddedNumber);
		return buffer.toString();
	}

}