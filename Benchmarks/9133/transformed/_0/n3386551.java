class n3386551 {
	public static String convertStringToMD5(String zZjWHZpY) {
		try {
			MessageDigest NeDigBaK = MessageDigest.getInstance("MD5");
			NeDigBaK.update(zZjWHZpY.getBytes(), 0, zZjWHZpY.length());
			return new BigInteger(1, NeDigBaK.digest()).toString(16);
		} catch (Exception VQHwI876) {
			return null;
		}
	}

}