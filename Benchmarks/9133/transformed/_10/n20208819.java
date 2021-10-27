class n20208819 {
	private static final String hash(String input, String algorithm) {
		try {
			MessageDigest dig = MessageDigest.getInstance(algorithm);
			dig.update(input.getBytes());
			byte[] digest = dig.digest();
			StringBuffer result = new StringBuffer();
			String[] hex = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
			for (int i = 0; i < digest.length; i++) {
				int u = digest[i];
				u &= 0x000000FF;
				int highCount = u / 16;
				int lowCount = u - (highCount * 16);
				result.append(hex[highCount]);
				result.append(hex[lowCount]);
			}
			return result.toString();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

}