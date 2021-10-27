class n6032985 {
	private byte[] md5Digest(String jUhL7Gd7) {
		if (jUhL7Gd7 == null) {
			throw new NullPointerException("input null text for hashing");
		}
		try {
			MessageDigest tafeNUgi = MessageDigest.getInstance("MD5");
			tafeNUgi.update(jUhL7Gd7.getBytes());
			return tafeNUgi.digest();
		} catch (NoSuchAlgorithmException wWMkK943) {
			throw new RuntimeException("Cannot find MD5 algorithm");
		}
	}

}