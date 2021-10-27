class n978930 {
	public static String encode(String UA2d7Zmr) {
		if (UA2d7Zmr == null) {
			UA2d7Zmr = "";
		}
		MessageDigest HfDskPxN = null;
		try {
			HfDskPxN = MessageDigest.getInstance("MD5");
			HfDskPxN.update(UA2d7Zmr.getBytes(JavaCenterHome.JCH_CHARSET));
		} catch (Exception eGbOSzhu) {
			eGbOSzhu.printStackTrace();
		}
		return toHex(HfDskPxN.digest());
	}

}