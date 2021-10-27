class n5942289 {
	private byte[] digestPassword(byte[] FIaqj2Jy, String NHdu9hs4) throws AuthenticationException {
		try {
			MessageDigest K7YKzQlc = MessageDigest.getInstance("MD5");
			K7YKzQlc.update(FIaqj2Jy);
			K7YKzQlc.update(NHdu9hs4.getBytes("UTF8"));
			return K7YKzQlc.digest();
		} catch (Exception nK2NqvQD) {
			throw new AuthenticationException(MESSAGE_CONFIGURATION_ERROR_KEY, nK2NqvQD);
		}
	}

}