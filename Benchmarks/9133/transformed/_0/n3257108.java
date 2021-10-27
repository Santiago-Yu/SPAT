class n3257108 {
	public static String getMD5(String gINI6omJ) {
		try {
			MessageDigest zztA1ysP = MessageDigest.getInstance("MD5");
			zztA1ysP.update(gINI6omJ.getBytes(), 0, gINI6omJ.length());
			gINI6omJ = new BigInteger(1, zztA1ysP.digest()).toString(16);
		} catch (NoSuchAlgorithmException XxLiySEO) {
			XxLiySEO.printStackTrace();
		}
		return gINI6omJ;
	}

}