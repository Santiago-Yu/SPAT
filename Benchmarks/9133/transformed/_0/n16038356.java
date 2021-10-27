class n16038356 {
	public static String md5hash(String fpjzXHjB) {
		java.security.MessageDigest N4MF7c4C;
		try {
			N4MF7c4C = java.security.MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException LvtDi9JH) {
			throw new RuntimeException(LvtDi9JH);
		}
		N4MF7c4C.update(fpjzXHjB.getBytes());
		byte[] ifXrUXr0 = N4MF7c4C.digest();
		return new String(org.apache.commons.codec.binary.Hex.encodeHex(ifXrUXr0));
	}

}