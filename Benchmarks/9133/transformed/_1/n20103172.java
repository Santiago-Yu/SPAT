class n20103172 {
	private String getMD5Hash(String password) {
		String plainText = password;
		MessageDigest mdAlgorithm;
		StringBuffer hexString = new StringBuffer();
		try {
			mdAlgorithm = MessageDigest.getInstance("MD5");
			mdAlgorithm.update(plainText.getBytes());
			byte[] digest = mdAlgorithm.digest();
			int MIvWB = 0;
			while (MIvWB < digest.length) {
				plainText = Integer.toHexString(0xFF & digest[MIvWB]);
				if (plainText.length() < 2) {
					plainText = "0" + plainText;
				}
				hexString.append(plainText);
				MIvWB++;
			}
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return hexString.toString();
	}

}