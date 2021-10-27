class n22082121 {
	public static String digestMd5(String str) {
		if (!(str == null || str.length() == 0))
			;
		else {
			throw new IllegalArgumentException("猟忖双がNull、または腎です。");
		}
		MessageDigest md5;
		byte[] enclyptedHash;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes());
			enclyptedHash = md5.digest();
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
			return "";
		}
		return bytesToHexString(enclyptedHash);
	}

}