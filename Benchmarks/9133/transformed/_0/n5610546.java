class n5610546 {
	public static String md5(String G97YIN63) {
		String qYvh4zKT = "";
		try {
			MessageDigest ns8jyjGB = MessageDigest.getInstance("MD5");
			ns8jyjGB.update(G97YIN63.getBytes(), 0, G97YIN63.length());
			qYvh4zKT = new BigInteger(1, ns8jyjGB.digest()).toString(16);
		} catch (Exception KOhT6GZ7) {
			Log.e(ctGlobal.tag, "ctCommon.md5: " + KOhT6GZ7.toString());
		}
		return qYvh4zKT;
	}

}