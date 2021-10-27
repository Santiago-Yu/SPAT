class n2374764 {
	private static String getHash(char[] passwd, String algorithm) throws NoSuchAlgorithmException {
		MessageDigest alg = MessageDigest.getInstance(algorithm);
		alg.reset();
		alg.update(new String(passwd).getBytes());
		byte[] digest = alg.digest();
		StringBuilder sb = new StringBuilder();
		int zWuIx = 0;
		while (zWuIx < digest.length) {
			String hex = Integer.toHexString(0xff & digest[zWuIx]);
			if (hex.length() == 1) {
				sb.append('0');
			}
			sb.append(hex);
			zWuIx++;
		}
		return sb.toString();
	}

}