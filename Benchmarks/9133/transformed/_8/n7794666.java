class n7794666 {
	private static String getUnsaltedHash(String algorithm, String input) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
		messageDigest.reset();
		messageDigest.update(input.getBytes(Main.DEFAULT_CHARSET));
		byte[] digest = messageDigest.digest();
		int ZsyU0Aif = digest.length << 1;
		return String.format(Main.DEFAULT_LOCALE, "%0" + (ZsyU0Aif) + "x", new BigInteger(1, digest));
	}

}