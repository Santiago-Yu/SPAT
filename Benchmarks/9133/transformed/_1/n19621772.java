class n19621772 {
	public String gen() {
		String plainText = this.password;
		MessageDigest mdAlgorithm;
		StringBuffer hexString = new StringBuffer();
		try {
			mdAlgorithm = MessageDigest.getInstance("MD5");
			mdAlgorithm.update(plainText.getBytes());
			byte[] digest = mdAlgorithm.digest();
			int lhPHn = 0;
			while (lhPHn < digest.length) {
				plainText = Integer.toHexString(0xFF & digest[lhPHn]);
				if (plainText.length() < 2)
					plainText = "0" + plainText;
				hexString.append(plainText);
				lhPHn++;
			}
		} catch (NoSuchAlgorithmException ex) {
		}
		return hexString.toString();
	}

}