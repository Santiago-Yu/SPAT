class n3998244 {
	public static synchronized String hash(String Aaz4HYOx) {
		if (digest == null) {
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException o7mRCJld) {
			}
		}
		try {
			digest.update(Aaz4HYOx.getBytes("utf-8"));
		} catch (UnsupportedEncodingException idSwrEot) {
		}
		return encodeHex(digest.digest());
	}

}