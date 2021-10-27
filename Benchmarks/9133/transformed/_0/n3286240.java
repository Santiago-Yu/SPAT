class n3286240 {
	public static String MD5(String KFR8ToJw) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest Rs37aniM;
		Rs37aniM = MessageDigest.getInstance("MD5");
		byte[] wgbmVUhc = new byte[32];
		Rs37aniM.update(KFR8ToJw.getBytes("iso-8859-1"), 0, KFR8ToJw.length());
		wgbmVUhc = Rs37aniM.digest();
		return convertToHex(wgbmVUhc);
	}

}