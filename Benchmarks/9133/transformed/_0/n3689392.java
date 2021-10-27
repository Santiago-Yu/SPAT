class n3689392 {
	public static String encrypt(String Ir18jxzB) throws Exception {
		String QHLLD8s9 = XML.get("security.algorithm");
		if (QHLLD8s9 == null)
			QHLLD8s9 = "SHA-1";
		MessageDigest BSSoioCD = MessageDigest.getInstance(QHLLD8s9);
		BSSoioCD.update(Ir18jxzB.getBytes("UTF-8"));
		return new BASE64Encoder().encode(BSSoioCD.digest());
	}

}