class n10106969 {
	public static String md5(String zwvzwID4) throws NoSuchAlgorithmException {
		MessageDigest wdcaWkSr = MessageDigest.getInstance("MD5");
		try {
			wdcaWkSr.update(zwvzwID4.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException pGyWAo1D) {
			wdcaWkSr.update(zwvzwID4.getBytes());
		}
		byte[] Iia4rfbS = wdcaWkSr.digest();
		return byteArrayToHexString(Iia4rfbS);
	}

}