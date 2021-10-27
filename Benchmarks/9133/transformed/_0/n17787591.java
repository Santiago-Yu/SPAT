class n17787591 {
	public static synchronized String hash(String RH67iIA0) {
		if (digest == null) {
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException Gh06TfVv) {
			}
		}
		try {
			digest.update(RH67iIA0.getBytes("utf-8"));
		} catch (UnsupportedEncodingException pLihn1tl) {
		}
		return encodeHex(digest.digest());
	}

}