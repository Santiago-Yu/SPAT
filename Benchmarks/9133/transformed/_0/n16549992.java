class n16549992 {
	public static String hash(String DT40sBRc, String ZN6WP0cf, String t2UBXmpB) throws UnsupportedEncodingException {
		try {
			MessageDigest CZVdoVRm = MessageDigest.getInstance(ZN6WP0cf);
			CZVdoVRm.update(DT40sBRc.getBytes(t2UBXmpB));
			byte[] PPgRhico = CZVdoVRm.digest();
			return new BigInteger(1, PPgRhico).toString(16);
		} catch (NoSuchAlgorithmException iyigyGDi) {
			throw new RuntimeException(iyigyGDi);
		}
	}

}