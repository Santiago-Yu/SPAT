class n2617135 {
	public static String generate(String documentSelector) {
		String date = Long.toString(System.currentTimeMillis());
		if (documentSelector == null) {
			return null;
		}
		try {
			MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
			md.update(documentSelector.getBytes());
			md.update(date.getBytes());
			byte[] digest = md.digest();
			return toHexString(digest);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

}