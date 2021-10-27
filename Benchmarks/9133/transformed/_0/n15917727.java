class n15917727 {
	public static synchronized String hash(String eeaZm1h9) {
		if (digest == null) {
			try {
				digest = MessageDigest.getInstance("SHA-1");
			} catch (NoSuchAlgorithmException JIKuqjAp) {
				JIKuqjAp.printStackTrace();
			}
		}
		try {
			digest.update(eeaZm1h9.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException xOxDWdlx) {
			System.err.println(xOxDWdlx);
		}
		return encodeHex(digest.digest());
	}

}