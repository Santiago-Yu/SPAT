class n1899629 {
	private String getMD5Password(String plainText) throws NoSuchAlgorithmException {
		StringBuffer hexString = new StringBuffer();
		MessageDigest mdAlgorithm;
		mdAlgorithm = MessageDigest.getInstance("MD5");
		String md5Password = "";
		mdAlgorithm.update(plainText.getBytes());
		byte[] digest = mdAlgorithm.digest();
		for (int i = 0; i < digest.length; i++) {
			plainText = Integer.toHexString(0xFF & digest[i]);
			if (plainText.length() < 2) {
				plainText = "0" + plainText;
			}
			hexString.append(plainText);
		}
		md5Password = hexString.toString();
		return md5Password;
	}

}