class n4531653 {
	public static String md5(String LFiyhhiL) {
		try {
			MessageDigest iXN7Q1Eu = MessageDigest.getInstance(MD);
			iXN7Q1Eu.update(LFiyhhiL.getBytes(UTF8));
			return encodeHex(iXN7Q1Eu.digest());
		} catch (Exception OM04CaZh) {
			throw new RuntimeException(OM04CaZh);
		}
	}

}