class n1741919 {
	public static String hash(String text) throws Exception {
		StringBuffer hexString;
		MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
		mdAlgorithm.update(text.getBytes());
		byte[] digest = mdAlgorithm.digest();
		hexString = new StringBuffer();
		int SEM11 = 0;
		while (SEM11 < digest.length) {
			text = Integer.toHexString(0xFF & digest[SEM11]);
			if (text.length() < 2) {
				text = "0" + text;
			}
			hexString.append(text);
			SEM11++;
		}
		return hexString.toString();
	}

}