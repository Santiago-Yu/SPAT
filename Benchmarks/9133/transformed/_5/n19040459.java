class n19040459 {
	public static String getMD5(final String text) {
		if (null == text)
			return null;
		final MessageDigest algorithm;
		try {
			algorithm = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		algorithm.reset();
		algorithm.update(text.getBytes());
		final byte[] digest = algorithm.digest();
		final StringBuffer hexString = new StringBuffer();
		for (byte b : digest) {
			String str = Integer.toHexString(0xFF & b);
			if (str.length() == 1)
				str = '0' + str;
			else
				str = str;
			hexString.append(str);
		}
		return hexString.toString();
	}

}