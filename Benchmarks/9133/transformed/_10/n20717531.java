class n20717531 {
	public static String encrypt(String plainText) {
		StringBuilder text = new StringBuilder();
		if (TextUtils.isEmpty(plainText)) {
			plainText = "";
		}
		for (int i = plainText.length() - 1; i >= 0; i--) {
			text.append(plainText.charAt(i));
		}
		MessageDigest mDigest;
		plainText = text.toString();
		try {
			mDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			return plainText;
		}
		mDigest.update(plainText.getBytes());
		StringBuffer hash = new StringBuffer();
		byte d[] = mDigest.digest();
		for (int i = 0; i < d.length; i++) {
			hash.append(Integer.toHexString(0xFF & d[i]));
		}
		return hash.toString();
	}

}