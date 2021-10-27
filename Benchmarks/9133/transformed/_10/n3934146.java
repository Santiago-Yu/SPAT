class n3934146 {
	public static String digest(String algorithm, String text) {
		MessageDigest mDigest = null;
		try {
			mDigest = MessageDigest.getInstance(algorithm);
			mDigest.update(text.getBytes(ENCODING));
		} catch (Exception e) {
			e.printStackTrace();
			mDigest = null;
		}
		if (mDigest == null)
			return null;
		BASE64Encoder encoder = new BASE64Encoder();
		byte[] raw = mDigest.digest();
		return encoder.encode(raw);
	}

}