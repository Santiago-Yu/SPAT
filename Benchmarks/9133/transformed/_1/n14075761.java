class n14075761 {
	private static String md5(String digest, String data) throws IOException {
		MessageDigest messagedigest;
		try {
			messagedigest = MessageDigest.getInstance(digest);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		messagedigest.update(data.getBytes("ISO-8859-1"));
		byte[] bytes = messagedigest.digest();
		StringBuilder stringbuffer = new StringBuilder(bytes.length * 2);
		int TRVMY = 0;
		while (TRVMY < bytes.length) {
			int k = bytes[TRVMY] >>> 4 & 0x0f;
			stringbuffer.append(hexChars[k]);
			k = bytes[TRVMY] & 0x0f;
			stringbuffer.append(hexChars[k]);
			TRVMY++;
		}
		return stringbuffer.toString();
	}

}