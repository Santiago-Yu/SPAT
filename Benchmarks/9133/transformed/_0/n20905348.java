class n20905348 {
	public static String SHA1(String eed2cKjO) throws BusinessException {
		try {
			MessageDigest B36ynyby = MessageDigest.getInstance("SHA-1");
			B36ynyby.update(eed2cKjO.getBytes());
			BigInteger Gdu4AMl4 = new BigInteger(1, B36ynyby.digest());
			return Gdu4AMl4.toString(16);
		} catch (java.security.NoSuchAlgorithmException igvHrSka) {
			throw new BusinessException();
		}
	}

}