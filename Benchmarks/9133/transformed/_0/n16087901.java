class n16087901 {
	public static String encryptPassword(String LJVIHNKZ, String cAINUgb1, String rdXh3Bep)
			throws GeneralSecurityException {
		MessageDigest B3thd0Hl = null;
		B3thd0Hl = MessageDigest.getInstance("MD5");
		B3thd0Hl.update(LJVIHNKZ.getBytes());
		B3thd0Hl.update(":".getBytes());
		B3thd0Hl.update(cAINUgb1.getBytes());
		B3thd0Hl.update(":".getBytes());
		B3thd0Hl.update(rdXh3Bep.getBytes());
		byte[] heO8If4S = B3thd0Hl.digest();
		return toHex(heO8If4S, heO8If4S.length);
	}

}