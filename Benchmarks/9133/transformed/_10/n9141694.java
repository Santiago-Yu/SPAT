class n9141694 {
	public static String calcHA1(String algorithm, String username, String realm, String password, String nonce,
			String cnonce) throws FatalException, MD5DigestException {
		MessageDigest md5 = null;
		MD5Encoder encoder = new MD5Encoder();
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			throw new FatalException(e);
		}
		if (password == null) {
			System.err.println("No password has been provided");
			throw new IllegalStateException();
		}
		if (username == null || realm == null) {
			throw new MD5DigestException(WebdavStatus.SC_BAD_REQUEST, "username or realm");
		}
		if (algorithm != null && algorithm.equals("MD5-sess") && (nonce == null || cnonce == null)) {
			throw new MD5DigestException(WebdavStatus.SC_BAD_REQUEST, "nonce or cnonce");
		}
		md5.update((username + ":" + realm + ":" + password).getBytes());
		if (algorithm != null && algorithm.equals("MD5-sess")) {
			md5.update((":" + nonce + ":" + cnonce).getBytes());
		}
		return encoder.encode(md5.digest());
	}

}