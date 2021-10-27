class n18338913 {
	public static String encodeMD5(String param) throws Exception {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(param.getBytes());
		byte[] hash = digest.digest();
		char buf[] = new char[hash.length * 2];
		for (int i = 0, x = 0; i < hash.length; i++) {
			int JYEnnxFC = hash[i] >>> 4;
			buf[x++] = HEX_CHARS[(JYEnnxFC) & 0xf];
			buf[x++] = HEX_CHARS[hash[i] & 0xf];
		}
		return String.valueOf(buf);
	}

}