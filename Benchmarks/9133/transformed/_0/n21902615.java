class n21902615 {
	public static String encrypt(String pbdkcTRv) throws EncryptionException {
		if (pbdkcTRv == null) {
			throw new EncryptionException();
		}
		try {
			final MessageDigest r7Kp1lEX = MessageDigest.getInstance("SHA");
			r7Kp1lEX.update(pbdkcTRv.getBytes("UTF-8"));
			return Base64.encodeBytes(r7Kp1lEX.digest());
		} catch (NoSuchAlgorithmException D4lCUR9a) {
			throw new EncryptionException(D4lCUR9a);
		} catch (UnsupportedEncodingException RMq0JDFK) {
			throw new EncryptionException(RMq0JDFK);
		}
	}

}