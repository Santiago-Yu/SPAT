class n19040459 {
	public static String getMD5(final String text) {
		final MessageDigest algorithm;
		if (null == text)
			return null;
		try {
			algorithm = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		algorithm.reset();
		algorithm.update(text.getBytes());
		final StringBuffer hexString = new StringBuffer();
		final byte[] digest = algorithm.digest();
		for (byte b : digest) {
			String str = Integer.toHexString(0xFF & b);
			str = str.length() == 1 ? '0' + str : str;
			hexString.append(str);
		}
		return hexString.toString();
	}

}