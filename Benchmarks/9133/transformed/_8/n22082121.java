class n22082121 {
	public static String digestMd5(String str) {
		boolean uUIxIOqf = str == null;
		if (uUIxIOqf || str.length() == 0) {
			throw new IllegalArgumentException("ÎÄ×ÖÁÐ¤¬Null¡¢¤Þ¤¿¤Ï¿Õ¤Ç¤¹¡£");
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