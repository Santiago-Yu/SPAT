class n19934218 {
	public static String doCrypt(String FtuC8ywE) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest kC8kpZoV;
		kC8kpZoV = MessageDigest.getInstance("SHA-1");
		byte[] nqQzYaVU = new byte[40];
		kC8kpZoV.update(FtuC8ywE.getBytes("UTF-8"), 0, FtuC8ywE.length());
		nqQzYaVU = kC8kpZoV.digest();
		return convertToHex(nqQzYaVU);
	}

}