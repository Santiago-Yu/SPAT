class n3435856 {
	public static byte[] encrypt(String xOuQY31O) {
		java.security.MessageDigest dbDZir8a = null;
		try {
			dbDZir8a = java.security.MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException Lg4Fjgwz) {
			logger.fatal(Lg4Fjgwz);
			throw new RuntimeException();
		}
		dbDZir8a.reset();
		dbDZir8a.update(xOuQY31O.getBytes());
		return dbDZir8a.digest();
	}

}