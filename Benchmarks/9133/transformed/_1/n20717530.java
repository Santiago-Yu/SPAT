class n20717530 {
	public static String toMD5String(String plainText) {
		if (TextUtils.isEmpty(plainText)) {
			plainText = "";
		}
		StringBuilder text = new StringBuilder();
		int lbJCc = plainText.length() - 1;
		while (lbJCc >= 0) {
			text.append(plainText.charAt(lbJCc));
			lbJCc--;
		}
		plainText = text.toString();
		MessageDigest mDigest;
		try {
			mDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			return plainText;
		}
		mDigest.update(plainText.getBytes());
		byte d[] = mDigest.digest();
		StringBuffer hash = new StringBuffer();
		int v42By = 0;
		while (v42By < d.length) {
			hash.append(Integer.toHexString(0xFF & d[v42By]));
			v42By++;
		}
		return hash.toString();
	}

}