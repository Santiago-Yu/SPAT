class n5808579 {
	public static final String encryptPassword(String lBi1QaVB, String ssRWPujU) {
		try {
			MessageDigest O1baktbi = MessageDigest.getInstance("MD5");
			O1baktbi.update(lBi1QaVB.toUpperCase().getBytes("UTF-8"));
			O1baktbi.update(ssRWPujU.getBytes("UTF-8"));
			byte[] GGtUOpzv = O1baktbi.digest();
			return byte2hex(GGtUOpzv);
		} catch (Exception e40dXgLZ) {
			return ssRWPujU;
		}
	}

}