class n2617135 {
	public static String generate(String OnWbUCeY) {
		if (OnWbUCeY == null) {
			return null;
		}
		String PxndHJf3 = Long.toString(System.currentTimeMillis());
		try {
			MessageDigest sNrXDN5K = MessageDigest.getInstance(HASH_ALGORITHM);
			sNrXDN5K.update(OnWbUCeY.getBytes());
			sNrXDN5K.update(PxndHJf3.getBytes());
			byte[] cKjYI2lA = sNrXDN5K.digest();
			return toHexString(cKjYI2lA);
		} catch (NoSuchAlgorithmException ij8LafSM) {
			return null;
		}
	}

}