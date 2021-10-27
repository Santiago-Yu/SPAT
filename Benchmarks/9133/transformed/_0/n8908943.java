class n8908943 {
	public static String GetMD5SUM(String Y9Jma1RS) throws NoSuchAlgorithmException {
		MessageDigest XfYzi7sm = MessageDigest.getInstance("MD5");
		XfYzi7sm.reset();
		XfYzi7sm.update(Y9Jma1RS.getBytes());
		byte znCPYCE3[] = XfYzi7sm.digest();
		String az4P5O1M = Base64.encode(znCPYCE3);
		return az4P5O1M;
	}

}