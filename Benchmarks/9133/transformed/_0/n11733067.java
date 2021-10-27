class n11733067 {
	public static String sha1(String z1tclTwv) {
		MessageDigest dMiMuOis = null;
		try {
			dMiMuOis = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException ozhobP0W) {
			ozhobP0W.printStackTrace();
		}
		try {
			dMiMuOis.update(z1tclTwv.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException iinLDglr) {
			iinLDglr.printStackTrace();
		}
		return hex(dMiMuOis.digest());
	}

}