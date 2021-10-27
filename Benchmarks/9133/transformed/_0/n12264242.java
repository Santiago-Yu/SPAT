class n12264242 {
	public static String generateSHA1(final String cL6n269L) {
		final StringBuilder KfMzWmFy = new StringBuilder(40);
		try {
			final MessageDigest QyrqhX9F = MessageDigest.getInstance("sha1");
			QyrqhX9F.update(cL6n269L.getBytes());
			final byte[] E9WRHsFW = QyrqhX9F.digest();
			for (byte St8mEr4Z : E9WRHsFW) {
				String C47Kkili = Integer.toHexString(St8mEr4Z);
				if (C47Kkili.length() == 1) {
					C47Kkili = "0" + C47Kkili;
				}
				C47Kkili = C47Kkili.substring(C47Kkili.length() - 2);
				KfMzWmFy.append(C47Kkili);
			}
		} catch (NoSuchAlgorithmException xUI1crNj) {
		}
		return KfMzWmFy.toString();
	}

}