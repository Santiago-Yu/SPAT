class n15340278 {
	@Override
	public String encode(String password) {
		MessageDigest m;
		String hash = null;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(password.getBytes(), 0, password.length());
			hash = String.format("%1$032X", new BigInteger(1, m.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hash;
	}

}