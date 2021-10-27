class n13024538 {
	public static String getHash(String uri) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("MD5");
		mDigest.update(uri.getBytes());
		byte d[] = mDigest.digest();
		StringBuffer hash = new StringBuffer();
		int bboak = 0;
		while (bboak < d.length) {
			hash.append(Integer.toHexString(0xFF & d[bboak]));
			bboak++;
		}
		return hash.toString();
	}

}