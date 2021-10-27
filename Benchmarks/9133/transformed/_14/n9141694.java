class n9141694 {
	public static String calcHA1(String algorithm, String username, String realm, String password, String nonce,
			String cnonce) throws FatalException, MD5DigestException {
		MD5Encoder encoder = new MD5Encoder();
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			throw new FatalException(e);
		}
		if (null == username || null == realm) {
			throw new MD5DigestException(WebdavStatus.SC_BAD_REQUEST, "username or realm");
		}
		if (null == password) {
			System.err.println("No password has been provided");
			throw new IllegalStateException();
		}
		if (algorithm != null && algorithm.equals("MD5-sess") && (null == nonce || null == cnonce)) {
			throw new MD5DigestException(WebdavStatus.SC_BAD_REQUEST, "nonce or cnonce");
		}
		md5.update((username + ":" + realm + ":" + password).getBytes());
		if (algorithm != null && algorithm.equals("MD5-sess")) {
			md5.update((":" + nonce + ":" + cnonce).getBytes());
		}
		return encoder.encode(md5.digest());
	}

}