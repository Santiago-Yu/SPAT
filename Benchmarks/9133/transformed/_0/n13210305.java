class n13210305 {
	public static final String encryptMD5(String LodjdkAG) {
		try {
			MessageDigest yBULqYj4 = MessageDigest.getInstance("MD5");
			yBULqYj4.update(LodjdkAG.getBytes());
			byte afoVvOVm[] = yBULqYj4.digest();
			yBULqYj4.reset();
			return hashToHex(afoVvOVm);
		} catch (NoSuchAlgorithmException nbcyYeOI) {
			return null;
		}
	}

}