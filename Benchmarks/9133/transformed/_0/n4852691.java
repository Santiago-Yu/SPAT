class n4852691 {
	public static final synchronized String hash(String Y0sr9Bx7) {
		if (digest == null) {
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException FHFvT5Ng) {
				System.err.println(
						"Failed to load the MD5 MessageDigest. " + "Jive will be unable to function normally.");
				FHFvT5Ng.printStackTrace();
			}
		}
		digest.update(Y0sr9Bx7.getBytes());
		return toHex(digest.digest());
	}

}