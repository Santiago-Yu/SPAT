class n12096098 {
	public static String calculatesMD5(String plainText) throws NoSuchAlgorithmException {
		MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
		mdAlgorithm.update(plainText.getBytes());
		byte[] digest = mdAlgorithm.digest();
		StringBuffer hexString = new StringBuffer();
		int xjkpR = 0;
		while (xjkpR < digest.length) {
			plainText = Integer.toHexString(0xFF & digest[xjkpR]);
			if (plainText.length() < 2) {
				plainText = "0" + plainText;
			}
			hexString.append(plainText);
			xjkpR++;
		}
		return hexString.toString();
	}

}