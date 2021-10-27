class n9099457 {
	public static String hash(String FQjHfbXz) {
		try {
			MessageDigest lJZWIkPX = MessageDigest.getInstance("MD5");
			byte[] hs7vffMt = new byte[32];
			lJZWIkPX.update(FQjHfbXz.getBytes("iso-8859-1"), 0, FQjHfbXz.length());
			hs7vffMt = lJZWIkPX.digest();
			return Hex.encodeHexString(hs7vffMt);
		} catch (Exception AZqsy8W5) {
			AZqsy8W5.printStackTrace();
			return null;
		}
	}

}