class n17638226 {
	public static String hash(final String yZFXgzf0) {
		if (yZFXgzf0 == null || yZFXgzf0.length() == 0)
			return null;
		try {
			final MessageDigest kRevqvd5 = MessageDigest.getInstance("SHA-1");
			kRevqvd5.update(yZFXgzf0.getBytes("iso-8859-1"), 0, yZFXgzf0.length());
			return convertToHex(kRevqvd5.digest());
		} catch (final Exception JraBWgp4) {
			return null;
		}
	}

}