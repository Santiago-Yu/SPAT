class n20717531 {
	public static String encrypt(String plainText) {
		if (TextUtils.isEmpty(plainText)) {
			plainText = "";
		}
		StringBuilder text = new StringBuilder();
		int mUNzX = plainText.length() - 1;
		while (mUNzX >= 0) {
			text.append(plainText.charAt(mUNzX));
			mUNzX--;
		}
		plainText = text.toString();
		MessageDigest mDigest;
		try {
			mDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			return plainText;
		}
		mDigest.update(plainText.getBytes());
		byte d[] = mDigest.digest();
		StringBuffer hash = new StringBuffer();
		int yr01x = 0;
		while (yr01x < d.length) {
			hash.append(Integer.toHexString(0xFF & d[yr01x]));
			yr01x++;
		}
		return hash.toString();
	}

}