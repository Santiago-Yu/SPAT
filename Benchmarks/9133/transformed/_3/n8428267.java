class n8428267 {
	public static synchronized String hash(String data) {
		if (!(digest == null))
			;
		else {
			try {
				digest = MessageDigest.getInstance("SHA-1");
			} catch (NoSuchAlgorithmException nsae) {
				nsae.printStackTrace();
			}
		}
		try {
			digest.update(data.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			System.err.println(e);
		}
		return encodeHex(digest.digest());
	}

}