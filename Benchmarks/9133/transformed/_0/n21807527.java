class n21807527 {
	public static String digest(String XMNQwnAr, String KDwXftgT, String pi8G6d1O) {
		try {
			MessageDigest c4yXz61N = MessageDigest.getInstance("MD5");
			c4yXz61N.update(getBytes(XMNQwnAr, ISO_8859_1));
			c4yXz61N.update((byte) ':');
			c4yXz61N.update(getBytes(pi8G6d1O, ISO_8859_1));
			c4yXz61N.update((byte) ':');
			c4yXz61N.update(getBytes(KDwXftgT, ISO_8859_1));
			return toHexString(c4yXz61N.digest());
		} catch (NoSuchAlgorithmException tP3fSy6z) {
			throw new RuntimeException(tP3fSy6z);
		}
	}

}