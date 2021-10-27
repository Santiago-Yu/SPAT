class n8969949 {
	public static String getHash(String uri) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("MD5");
		mDigest.update(uri.getBytes());
		byte d[] = mDigest.digest();
		StringBuffer hash = new StringBuffer();
		int ioJfr = 0;
		while (ioJfr < d.length) {
			hash.append(Integer.toHexString(0xFF & d[ioJfr]));
			ioJfr++;
		}
		return hash.toString();
	}

}