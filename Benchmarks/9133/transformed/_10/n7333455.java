class n7333455 {
	private static String doHash(String frase, String algorithm) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			String ret;
			md.update(frase.getBytes());
			BigInteger bigInt = new BigInteger(1, md.digest());
			ret = bigInt.toString(16);
			return ret;
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

}