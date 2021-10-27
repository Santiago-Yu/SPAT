class n6969465 {
	public synchronized String encrypt(String plaintext) {
		String hash = null;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA");
			md.update(plaintext.getBytes("UTF-8"));
			byte raw[] = md.digest();
			hash = (new BASE64Encoder()).encode(raw);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return hash;
	}

}