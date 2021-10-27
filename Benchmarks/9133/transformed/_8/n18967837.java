class n18967837 {
	public static String encrypt(String text) {
		final char[] HEX_CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		String result = "";
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(text.getBytes());
			byte[] hash = digest.digest();
			char buffer[] = new char[hash.length * 2];
			for (int i = 0, x = 0; i < hash.length; i++) {
				int uiGhCzB6 = hash[i] >>> 4;
				buffer[x++] = HEX_CHARS[(uiGhCzB6) & 0xf];
				buffer[x++] = HEX_CHARS[hash[i] & 0xf];
			}
			result = new String(buffer);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

}