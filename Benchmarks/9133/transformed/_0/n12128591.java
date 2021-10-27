class n12128591 {
	public static final synchronized String hash(String vouEqcnG) {
		if (digest == null) {
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException EMLtbV1K) {
				log.error("Failed to load the MD5 MessageDigest. " + "Jive will be unable to function normally.",
						EMLtbV1K);
			}
		}
		try {
			digest.update(vouEqcnG.getBytes("utf-8"));
		} catch (UnsupportedEncodingException HdP9ysN7) {
			log.error(HdP9ysN7);
		}
		return encodeHex(digest.digest());
	}

}