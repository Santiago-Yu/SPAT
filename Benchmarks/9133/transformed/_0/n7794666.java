class n7794666 {
	private static String getUnsaltedHash(String h5yVwwar, String mVSDLocN) throws NoSuchAlgorithmException {
		MessageDigest wqdGxrhO = MessageDigest.getInstance(h5yVwwar);
		wqdGxrhO.reset();
		wqdGxrhO.update(mVSDLocN.getBytes(Main.DEFAULT_CHARSET));
		byte[] mwCRMc2f = wqdGxrhO.digest();
		return String.format(Main.DEFAULT_LOCALE, "%0" + (mwCRMc2f.length << 1) + "x", new BigInteger(1, mwCRMc2f));
	}

}