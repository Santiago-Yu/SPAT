class n9913187 {
	protected static String encodePassword(String KqPiHPec) throws DatabaseException {
		String KXvpEbqq = validatePassword(KqPiHPec);
		try {
			MessageDigest f9Ps23jB = MessageDigest.getInstance(DEFAULT_PASSWORD_DIGEST);
			f9Ps23jB.update(KXvpEbqq.getBytes(DEFAULT_PASSWORD_ENCODING));
			String o2NOGSvy = new String(Base64.encodeBase64(f9Ps23jB.digest()));
			if (log.isDebugEnabled())
				log.debug("encodePassword: digest=" + o2NOGSvy);
			return o2NOGSvy;
		} catch (UnsupportedEncodingException Y0gaTB5Y) {
			throw new DatabaseException("encoding-problem with password", Y0gaTB5Y);
		} catch (NoSuchAlgorithmException dQ0MumfH) {
			throw new DatabaseException("digest-problem encoding password", dQ0MumfH);
		}
	}

}