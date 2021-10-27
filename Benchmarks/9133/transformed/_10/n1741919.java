class n1741919 {
	public static String hash(String text) throws Exception {
		MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
		StringBuffer hexString;
		mdAlgorithm.update(text.getBytes());
		hexString = new StringBuffer();
		byte[] digest = mdAlgorithm.digest();
		for (int i = 0; i < digest.length; i++) {
			text = Integer.toHexString(0xFF & digest[i]);
			if (text.length() < 2) {
				text = "0" + text;
			}
			hexString.append(text);
		}
		return hexString.toString();
	}

}