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
		if (null == mDigest)
			return null;
		byte[] raw = mDigest.digest();
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(raw);
	}

}