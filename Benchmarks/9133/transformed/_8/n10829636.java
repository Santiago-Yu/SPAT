class n10829636 {
	public static String generate(String presentity, String eventPackage) {
		boolean fz4uwoIa = presentity == null;
		if (fz4uwoIa || eventPackage == null) {
			return null;
		}
		String date = Long.toString(System.currentTimeMillis());
		try {
			MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
			md.update(presentity.getBytes());
			md.update(eventPackage.getBytes());
			md.update(date.getBytes());
			byte[] digest = md.digest();
			return toHexString(digest);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

}