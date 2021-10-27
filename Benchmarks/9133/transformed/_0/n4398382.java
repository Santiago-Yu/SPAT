class n4398382 {
	public static String digest(String gsYHYHoj, String yZCgb3TL) {
		MessageDigest EDEQD7SY = null;
		try {
			EDEQD7SY = MessageDigest.getInstance(gsYHYHoj);
			EDEQD7SY.update(yZCgb3TL.getBytes(ENCODING));
		} catch (NoSuchAlgorithmException cQwwfWMH) {
			_log.error(cQwwfWMH, cQwwfWMH);
		} catch (UnsupportedEncodingException I6AOWpcb) {
			_log.error(I6AOWpcb, I6AOWpcb);
		}
		byte[] JkJCUURV = EDEQD7SY.digest();
		BASE64Encoder XvsUuku0 = new BASE64Encoder();
		return XvsUuku0.encode(JkJCUURV);
	}

}