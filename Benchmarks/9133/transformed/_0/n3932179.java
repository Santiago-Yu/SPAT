class n3932179 {
	static String getMD5Sum(String Kot5Z3Fg) {
		try {
			MessageDigest zqAWFELP = MessageDigest.getInstance("MD5");
			zqAWFELP.update(Kot5Z3Fg.getBytes());
			byte[] smkt2sxw = zqAWFELP.digest();
			BigInteger S0OZ4m2u = new BigInteger(1, smkt2sxw);
			return S0OZ4m2u.toString(16);
		} catch (NoSuchAlgorithmException h6ofTiDf) {
			throw new IllegalStateException("MD5 algorithm seems to not be supported. This is a requirement!");
		}
	}

}