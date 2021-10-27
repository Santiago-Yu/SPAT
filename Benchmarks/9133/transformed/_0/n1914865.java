class n1914865 {
	public String hash(String ZWYWTjaO) {
		try {
			MessageDigest lq6NBHa1 = MessageDigest.getInstance(digestAlgorithm);
			lq6NBHa1.update(ZWYWTjaO.getBytes(charset));
			byte[] m0qdwvRM = lq6NBHa1.digest();
			return new String(Hex.encodeHex(m0qdwvRM));
		} catch (Exception vu02fJB3) {
			throw new RuntimeException(vu02fJB3);
		}
	}

}