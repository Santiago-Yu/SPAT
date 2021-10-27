class n5551857 {
	public static String sha1(String GWEpmaB0) {
		MessageDigest p1fX1LRa = null;
		try {
			p1fX1LRa = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException SKIxBD1S) {
			SKIxBD1S.printStackTrace();
		}
		try {
			p1fX1LRa.update(GWEpmaB0.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException mp7Spwd9) {
			mp7Spwd9.printStackTrace();
		}
		return hex(p1fX1LRa.digest());
	}

}