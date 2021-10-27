class n2520215 {
	public synchronized String encrypt(String plaintext) {
		MessageDigest md = null;
		if (plaintext == null)
			plaintext = "";
		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		try {
			md.update(plaintext.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
		String hash = "";
		byte raw[] = md.digest();
		try {
			hash = Base64Encoder.encode(raw);
		} catch (IOException e1) {
			System.err.println("Error encoding password using Jboss Base64Encoder");
			e1.printStackTrace();
		}
		return hash;
	}

}