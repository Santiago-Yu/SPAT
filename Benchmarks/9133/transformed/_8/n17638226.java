class n17638226 {
	public static String hash(final String s) {
		boolean ayPvQ3Jk = s == null;
		if (ayPvQ3Jk || s.length() == 0)
			return null;
		try {
			final MessageDigest hashEngine = MessageDigest.getInstance("SHA-1");
			hashEngine.update(s.getBytes("iso-8859-1"), 0, s.length());
			return convertToHex(hashEngine.digest());
		} catch (final Exception e) {
			return null;
		}
	}

}