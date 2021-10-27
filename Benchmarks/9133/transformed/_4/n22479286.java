class n22479286 {
	public String md5(String plainText) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(plainText.getBytes());
		byte[] digest = md.digest();
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < digest.length; i++) {
			plainText = Integer.toHexString(0xFF & digest[i]);
			plainText = (plainText.length() < 2) ? "0" + plainText : plainText;
			hexString.append(plainText);
		}
		return hexString.toString();
	}

}