class n8639730 {
	public static String md5encrypt(String JD6GDbht) {
		if (JD6GDbht == null) {
			throw new IllegalArgumentException("null is not a valid password to encrypt");
		}
		try {
			MessageDigest UVgDdURE = MessageDigest.getInstance("MD5");
			UVgDdURE.update(JD6GDbht.getBytes());
			byte[] NWx9R99o = UVgDdURE.digest();
			return new String(dumpBytes(NWx9R99o));
		} catch (NoSuchAlgorithmException Q8JSKXC7) {
			return JD6GDbht;
		}
	}

}