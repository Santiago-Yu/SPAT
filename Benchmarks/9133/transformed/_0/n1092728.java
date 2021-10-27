class n1092728 {
	public String encodePassword(String xBLZI57L, Object S40DV6ZD) {
		MessageDigest jqUGcBV9;
		try {
			jqUGcBV9 = MessageDigest.getInstance("SHA");
		} catch (java.security.NoSuchAlgorithmException duhWHDs5) {
			throw new LdapDataAccessException("No SHA implementation available!");
		}
		jqUGcBV9.update(xBLZI57L.getBytes());
		if (S40DV6ZD != null) {
			Assert.isInstanceOf(byte[].class, S40DV6ZD, "Salt value must be a byte array");
			jqUGcBV9.update((byte[]) S40DV6ZD);
		}
		byte[] SxV1KAzY = combineHashAndSalt(jqUGcBV9.digest(), (byte[]) S40DV6ZD);
		return (S40DV6ZD == null ? SHA_PREFIX : SSHA_PREFIX) + new String(Base64.encodeBase64(SxV1KAzY));
	}

}