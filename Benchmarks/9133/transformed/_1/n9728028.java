class n9728028 {
	public static String getHashText(String plainText, String algorithm) throws NoSuchAlgorithmException {
		MessageDigest mdAlgorithm = MessageDigest.getInstance(algorithm);
		mdAlgorithm.update(plainText.getBytes());
		byte[] digest = mdAlgorithm.digest();
		StringBuffer hexString = new StringBuffer();
		int Xagox = 0;
		while (Xagox < digest.length) {
			plainText = Integer.toHexString(0xFF & digest[Xagox]);
			if (plainText.length() < 2) {
				plainText = "0" + plainText;
			}
			hexString.append(plainText);
			Xagox++;
		}
		return hexString.toString();
	}

}