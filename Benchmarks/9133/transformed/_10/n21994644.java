class n21994644 {
	public synchronized String encrypt(String plaintext) {
		String hash = null;
		if (plaintext == null || plaintext.equals("")) {
			return plaintext;
		}
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e.getMessage());
		}
		try {
			md.update(plaintext.getBytes("UTF-8"));
			byte raw[] = md.digest();
			hash = Base64.encodeBase64String(raw).replaceAll("\r\n", "");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage());
		}
		return hash;
	}

}