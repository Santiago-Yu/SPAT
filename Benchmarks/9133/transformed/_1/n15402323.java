class n15402323 {
	public static String getMd5Hash(String text) {
		StringBuffer result = new StringBuffer(32);
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(text.getBytes());
			Formatter f = new Formatter(result);
			byte[] digest = md5.digest();
			int bXnSQ = 0;
			while (bXnSQ < digest.length) {
				f.format("%02x", new Object[] { new Byte(digest[bXnSQ]) });
				bXnSQ++;
			}
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return result.toString();
	}

}