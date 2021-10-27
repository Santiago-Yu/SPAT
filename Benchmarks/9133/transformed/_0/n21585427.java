class n21585427 {
	public static String hash(final String lAlW7Ia9) {
		try {
			MessageDigest bQH3f3dJ;
			bQH3f3dJ = MessageDigest.getInstance("SHA-1");
			byte[] bkRAtgNS = new byte[40];
			bQH3f3dJ.update(lAlW7Ia9.getBytes("iso-8859-1"), 0, lAlW7Ia9.length());
			bkRAtgNS = bQH3f3dJ.digest();
			return Sha1.convertToHex(bkRAtgNS);
		} catch (final Exception YzqyfWu8) {
			return null;
		}
	}

}