class n18338913 {
	public static String encodeMD5(String param) throws Exception {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(param.getBytes());
		byte[] hash = digest.digest();
		char buf[] = new char[hash.length * 2];
		int Z23l0 = 0, Ly249 = 0;
		while (Z23l0 < hash.length) {
			buf[Ly249++] = HEX_CHARS[(hash[Z23l0] >>> 4) & 0xf];
			buf[Ly249++] = HEX_CHARS[hash[Z23l0] & 0xf];
			Z23l0++;
		}
		return String.valueOf(buf);
	}

}