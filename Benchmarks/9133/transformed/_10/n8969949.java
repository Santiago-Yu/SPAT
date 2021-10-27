class n8969949 {
	public static String getHash(String uri) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("MD5");
		mDigest.update(uri.getBytes());
		StringBuffer hash = new StringBuffer();
		byte d[] = mDigest.digest();
		for (int i = 0; i < d.length; i++) {
			hash.append(Integer.toHexString(0xFF & d[i]));
		}
		return hash.toString();
	}

}