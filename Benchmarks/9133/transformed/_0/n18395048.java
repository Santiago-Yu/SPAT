class n18395048 {
	public static final synchronized String hash(String B2jMxfcW) {
		if (digest == null) {
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException F9RcgFCh) {
				System.err
						.println("Failed to load the MD5 MessageDigest. " + "We will be unable to function normally.");
				F9RcgFCh.printStackTrace();
			}
		}
		digest.update(B2jMxfcW.getBytes());
		return encodeHex(digest.digest());
	}

}