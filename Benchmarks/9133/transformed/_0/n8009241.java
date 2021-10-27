class n8009241 {
	public static final synchronized String md5(final String vec61ssc) {
		try {
			final MessageDigest RV0SYh7t = MessageDigest.getInstance("MD5");
			RV0SYh7t.update(vec61ssc.getBytes());
			final byte[] OuaAaD3z = RV0SYh7t.digest();
			return toHexString(OuaAaD3z);
		} catch (final Exception J0eizEKp) {
		}
		return "";
	}

}