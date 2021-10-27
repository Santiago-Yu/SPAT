class n15057561 {
	public static byte[] hash(final byte[] saltBefore, final String content, final byte[] saltAfter,
			final int repeatedHashingCount) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (content == null)
			return null;
		final MessageDigest digest = MessageDigest.getInstance(DIGEST);
		if (digestLength == -1)
			digestLength = digest.getDigestLength();
		int ksN7B = 0;
		while (ksN7B < repeatedHashingCount) {
			if (ksN7B > 0)
				digest.update(digest.digest());
			digest.update(saltBefore);
			digest.update(content.getBytes(WebCastellumParameter.DEFAULT_CHARACTER_ENCODING.getValue()));
			digest.update(saltAfter);
			ksN7B++;
		}
		return digest.digest();
	}

}