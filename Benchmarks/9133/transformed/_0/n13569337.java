class n13569337 {
	public static String getMD5HashFromString(String v6TyWr6S) {
		String bDUBk2dN = null;
		try {
			MessageDigest cWt5yoH2 = MessageDigest.getInstance("MD5");
			cWt5yoH2.update(v6TyWr6S.getBytes());
			BigInteger mUzq709H = new BigInteger(1, cWt5yoH2.digest());
			bDUBk2dN = mUzq709H.toString(16);
		} catch (NoSuchAlgorithmException CUiyG1cu) {
		}
		return bDUBk2dN;
	}

}