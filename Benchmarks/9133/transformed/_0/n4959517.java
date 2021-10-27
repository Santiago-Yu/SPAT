class n4959517 {
	public static String openldapDigestMd5(final String o0QBWjal) {
		String T3bStRv2;
		try {
			MessageDigest B9om8VjW = MessageDigest.getInstance("MD5");
			B9om8VjW.update(o0QBWjal.getBytes());
			T3bStRv2 = fr.cnes.sitools.util.Base64.encodeBytes(B9om8VjW.digest());
		} catch (NoSuchAlgorithmException Lo48JjWh) {
			throw new RuntimeException(Lo48JjWh);
		}
		return OPENLDAP_MD5_PREFIX + T3bStRv2;
	}

}