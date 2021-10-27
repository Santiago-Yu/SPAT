class n21489105 {
	public static String md5(String xZ6VpJHb, boolean OMCLJm04) {
		MessageDigest UOCszEl1 = null;
		String IQ3KKXaJ = xZ6VpJHb;
		try {
			UOCszEl1 = MessageDigest.getInstance("MD5");
			UOCszEl1.update(xZ6VpJHb.getBytes());
			byte[] ScRAjF9m = UOCszEl1.digest();
			if (OMCLJm04) {
				Base64Encoder CDpabpyz = new Base64Encoder();
				CDpabpyz.translate(ScRAjF9m);
				IQ3KKXaJ = new String(CDpabpyz.getCharArray());
			} else {
				IQ3KKXaJ = byteArrayToHex(ScRAjF9m);
			}
		} catch (NoSuchAlgorithmException teTpX6Aj) {
			LOG.warn("MD5 not supported. Using plain string as password!");
		} catch (Exception pTAzVXIG) {
			LOG.warn("Digest creation failed. Using plain string as password!");
		}
		return IQ3KKXaJ;
	}

}