class n18396375 {
	public static String hash(String plaintext) {
		MessageDigest md = null;
		if (plaintext == null) {
			return "";
		}
		try {
			md = MessageDigest.getInstance("SHA1");
			md.update(plaintext.getBytes("UTF-8"));
		} catch (Exception e) {
		}
		return new String(Base64.encodeBase64(md.digest()));
	}

}