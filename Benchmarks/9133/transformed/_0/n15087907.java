class n15087907 {
	public static final synchronized String hash(String uUW0bUFG) {
		if (digest == null) {
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException w64OY5QY) {
				System.err
						.println("Failed to load the MD5 MessageDigest. " + "We will be unable to function normally.");
				w64OY5QY.printStackTrace();
			}
		}
		digest.update(uUW0bUFG.getBytes());
		return encodeHex(digest.digest());
	}

}