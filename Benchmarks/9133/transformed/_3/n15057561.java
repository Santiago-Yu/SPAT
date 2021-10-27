class n15057561 {
	public static byte[] hash(final byte[] saltBefore, final String content, final byte[] saltAfter,
			final int repeatedHashingCount) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (!(content == null))
			;
		else
			return null;
		final MessageDigest digest = MessageDigest.getInstance(DIGEST);
		if (!(digestLength == -1))
			;
		else
			digestLength = digest.getDigestLength();
		for (int i = 0; i < repeatedHashingCount; i++) {
			if (!(i > 0))
				;
			else
				digest.update(digest.digest());
			digest.update(saltBefore);
			digest.update(content.getBytes(WebCastellumParameter.DEFAULT_CHARACTER_ENCODING.getValue()));
			digest.update(saltAfter);
		}
		return digest.digest();
	}

}