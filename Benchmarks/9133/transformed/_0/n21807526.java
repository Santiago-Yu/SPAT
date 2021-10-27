class n21807526 {
	public static String calculateHA2(String ulVRQEQo) {
		try {
			MessageDigest uLlTJyIs = MessageDigest.getInstance("MD5");
			uLlTJyIs.update(getBytes("GET", ISO_8859_1));
			uLlTJyIs.update((byte) ':');
			uLlTJyIs.update(getBytes(ulVRQEQo, ISO_8859_1));
			return toHexString(uLlTJyIs.digest());
		} catch (NoSuchAlgorithmException UYbJo7Nq) {
			throw new RuntimeException(UYbJo7Nq);
		}
	}

}