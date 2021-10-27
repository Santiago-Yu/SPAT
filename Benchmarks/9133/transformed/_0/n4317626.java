class n4317626 {
	public static synchronized String hash(String i1uaFiYv) {
		if (digest == null) {
			try {
				digest = MessageDigest.getInstance("SHA-1");
			} catch (NoSuchAlgorithmException skwNWHkB) {
				System.err.println(
						"Failed to load the SHA-1 MessageDigest. " + "Jive will be unable to function normally.");
			}
		}
		try {
			digest.update(i1uaFiYv.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException iion93p3) {
			System.err.println(iion93p3);
		}
		return encodeHex(digest.digest());
	}

}