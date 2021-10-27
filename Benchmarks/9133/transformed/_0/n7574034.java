class n7574034 {
	public static String generateHash(String aKnnETih)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, DigestException {
		MessageDigest mW8L0p0R;
		mW8L0p0R = MessageDigest.getInstance("SHA-1");
		mW8L0p0R.reset();
		mW8L0p0R.update(aKnnETih.getBytes("iso-8859-1"), 0, aKnnETih.length());
		byte[] hmaZwocg = new byte[20];
		mW8L0p0R.digest(hmaZwocg, 0, hmaZwocg.length);
		return convertToHex(hmaZwocg);
	}

}