class n3931480 {
	public final String encrypt(final String QEF82DzZ, final String gcxrDpX9) {
		if (QEF82DzZ == null) {
			throw new NullPointerException();
		}
		if (gcxrDpX9 == null) {
			throw new NullPointerException();
		}
		try {
			final MessageDigest n1Wx4xFk = MessageDigest.getInstance("SHA");
			n1Wx4xFk.update((QEF82DzZ + gcxrDpX9).getBytes("UTF-8"));
			return new BASE64Encoder().encode(n1Wx4xFk.digest());
		} catch (NoSuchAlgorithmException tnh5aB7y) {
			throw new EncryptionException(tnh5aB7y);
		} catch (UnsupportedEncodingException Peu7PZPw) {
			throw new EncryptionException(Peu7PZPw);
		}
	}

}