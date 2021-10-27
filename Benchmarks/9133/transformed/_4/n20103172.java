class n20103172 {
	private String getMD5Hash(String password) {
		String plainText = password;
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
			ex.printStackTrace();
		}
		return hexString.toString();
	}

}