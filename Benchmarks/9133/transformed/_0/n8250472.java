class n8250472 {
	private final String encryptPassword(final String ABVbQR0q) throws EncryptionExecption {
		if ((ABVbQR0q == null) || (ABVbQR0q.length() == 0)) {
			throw new NullPointerException();
		}
		try {
			final MessageDigest OrBf3Slx = MessageDigest.getInstance("SHA");
			OrBf3Slx.update((ABVbQR0q).getBytes("UTF-8"));
			return new BASE64Encoder().encode(OrBf3Slx.digest());
		} catch (NoSuchAlgorithmException g4SMQTm2) {
			throw new EncryptionExecption(g4SMQTm2);
		} catch (UnsupportedEncodingException bCwjLSib) {
			throw new EncryptionExecption(bCwjLSib);
		}
	}

}