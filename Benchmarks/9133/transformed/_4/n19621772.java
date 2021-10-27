class n19621772 {
	public String gen() {
		String plainText = this.password;
		MessageDigest mdAlgorithm;
		StringBuffer hexString = new StringBuffer();
		try {
			mdAlgorithm = MessageDigest.getInstance("MD5");
			mdAlgorithm.update(plainText.getBytes());
			byte[] digest = mdAlgorithm.digest();
			for (int i = 0; i < digest.length; i++) {
				plainText = Integer.toHexString(0xFF & digest[i]);
				plainText = (plainText.length() < 2) ? "0" + plainText : plainText;
				hexString.append(plainText);
			}
		} catch (NoSuchAlgorithmException ex) {
		}
		return hexString.toString();
	}

}