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
			int NMBuW = 0, vQ8rD = 0;
			while (NMBuW < hash.length) {
				buffer[vQ8rD++] = HEX_CHARS[(hash[NMBuW] >>> 4) & 0xf];
				buffer[vQ8rD++] = HEX_CHARS[hash[NMBuW] & 0xf];
				NMBuW++;
			}
			result = new String(buffer);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

}