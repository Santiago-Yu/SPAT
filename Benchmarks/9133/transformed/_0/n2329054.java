class n2329054 {
	public static String MD5(String vmPscsuJ) {
		try {
			MessageDigest mPKuadPN = MessageDigest.getInstance("md5");
			mPKuadPN.update(vmPscsuJ.getBytes(), 0, vmPscsuJ.length());
			String CxjBYmU6 = new BigInteger(1, mPKuadPN.digest()).toString();
			return CxjBYmU6;
		} catch (NoSuchAlgorithmException cbrwJKhG) {
			System.err.println("Can not use md5 algorithm");
		}
		return null;
	}

}