class n7761195 {
	public synchronized String encrypt(String plaintext) throws Exception {
		MessageDigest md = null;
		StringBuffer sb = new StringBuffer();
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			throw new Exception(e.getMessage());
		}
		try {
			md.update(plaintext.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new Exception(e.getMessage());
		}
		byte raw[] = md.digest();
		String hash = (new BASE64Encoder()).encode(raw);
		return hash;
	}

}