class n14843583 {
	public static String encryptSHA(String uK8Eiz53) throws NoSuchAlgorithmException {
		MessageDigest GcGjSdDf = java.security.MessageDigest.getInstance("SHA-1");
		GcGjSdDf.reset();
		GcGjSdDf.update(uK8Eiz53.getBytes());
		BASE64Encoder nlOpVbiF = new BASE64Encoder();
		return nlOpVbiF.encode(GcGjSdDf.digest());
	}

}