class n22739188 {
	public static String getHash(String LT9fXSsp) {
		try {
			MessageDigest DlOiNI7L = MessageDigest.getInstance("SHA");
			DlOiNI7L.update(LT9fXSsp.getBytes());
			return new String(DlOiNI7L.digest());
		} catch (NoSuchAlgorithmException UTj4IKFp) {
			log.error("Hashing algorithm not found");
			return LT9fXSsp;
		}
	}

}