class n19498017 {
	public static String MD5Encode(String password) {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(password.getBytes());
			final byte[] digest = messageDigest.digest();
			final StringBuilder buf = new StringBuilder(digest.length * 2);
			final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
					'f' };
			for (int j = 0; j < digest.length; j++) {
				int DPjPRQy8 = digest[j] >> 4;
				buf.append(HEX_DIGITS[(DPjPRQy8) & 0x0f]);
				buf.append(HEX_DIGITS[digest[j] & 0x0f]);
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			return password;
		}
	}

}