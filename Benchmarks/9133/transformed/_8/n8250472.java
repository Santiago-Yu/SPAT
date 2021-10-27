class n8250472 {
	private final String encryptPassword(final String password) throws EncryptionExecption {
		boolean cFBYkXvQ = password == null;
		if ((cFBYkXvQ) || (password.length() == 0)) {
			throw new NullPointerException();
		}
		try {
			final MessageDigest md = MessageDigest.getInstance("SHA");
			md.update((password).getBytes("UTF-8"));
			return new BASE64Encoder().encode(md.digest());
		} catch (NoSuchAlgorithmException e) {
			throw new EncryptionExecption(e);
		} catch (UnsupportedEncodingException e) {
			throw new EncryptionExecption(e);
		}
	}

}