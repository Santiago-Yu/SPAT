class n12553787 {
	public static String getHash(String plaintext) {
		String hash = null;
		try {
			MessageDigest md = null;
			String text = plaintext;
			try {
				md = MessageDigest.getInstance("SHA-256");
				md.update(text.getBytes("UTF-8"));
				byte[] rawBytes = md.digest();
				hash = new BASE64Encoder().encode(rawBytes);
			} catch (NoSuchAlgorithmException e) {
			}
		} catch (IOException e) {
		}
		return hash;
	}

}