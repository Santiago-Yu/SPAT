class n1235538 {
	public static String encrypt(final String UojVpFuH) {
		try {
			final MessageDigest GwpqDcZe = MessageDigest.getInstance("SHA");
			GwpqDcZe.update(UojVpFuH.getBytes("UTF-8"));
			return new String(Base64.encodeBase64(GwpqDcZe.digest()));
		} catch (final Exception hvXWJXG2) {
			throw new RuntimeException("No se pudo encriptar el password.", hvXWJXG2);
		}
	}

}