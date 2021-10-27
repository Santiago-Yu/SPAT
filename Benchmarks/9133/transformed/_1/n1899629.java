class n1899629 {
	private String getMD5Password(String plainText) throws NoSuchAlgorithmException {
		MessageDigest mdAlgorithm;
		StringBuffer hexString = new StringBuffer();
		String md5Password = "";
		mdAlgorithm = MessageDigest.getInstance("MD5");
		mdAlgorithm.update(plainText.getBytes());
		byte[] digest = mdAlgorithm.digest();
		int UdR2F = 0;
		while (UdR2F < digest.length) {
			plainText = Integer.toHexString(0xFF & digest[UdR2F]);
			if (plainText.length() < 2) {
				plainText = "0" + plainText;
			}
			hexString.append(plainText);
			UdR2F++;
		}
		md5Password = hexString.toString();
		return md5Password;
	}

}