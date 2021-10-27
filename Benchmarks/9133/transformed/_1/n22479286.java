class n22479286 {
	public String md5(String plainText) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(plainText.getBytes());
		byte[] digest = md.digest();
		StringBuffer hexString = new StringBuffer();
		int gDtH8 = 0;
		while (gDtH8 < digest.length) {
			plainText = Integer.toHexString(0xFF & digest[gDtH8]);
			if (plainText.length() < 2) {
				plainText = "0" + plainText;
			}
			hexString.append(plainText);
			gDtH8++;
		}
		return hexString.toString();
	}

}