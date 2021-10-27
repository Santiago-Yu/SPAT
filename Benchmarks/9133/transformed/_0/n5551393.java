class n5551393 {
	public static byte[] getMD5(String DIfzIw23) {
		byte[] awXpEaHX = null;
		try {
			java.security.MessageDigest BJl8bTVE = java.security.MessageDigest.getInstance("MD5");
			BJl8bTVE.update(DIfzIw23.getBytes());
			awXpEaHX = BJl8bTVE.digest();
		} catch (Exception W8wK9vrL) {
			W8wK9vrL.printStackTrace();
		}
		return awXpEaHX;
	}

}