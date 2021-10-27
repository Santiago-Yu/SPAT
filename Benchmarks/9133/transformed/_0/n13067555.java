class n13067555 {
	public static String MD5Digest(String YZ3bfPWr) {
		MessageDigest KS9fYd5T;
		try {
			KS9fYd5T = java.security.MessageDigest.getInstance("MD5");
			KS9fYd5T.update(YZ3bfPWr.getBytes("UTF8"));
			byte[] IEOdr4dh = KS9fYd5T.digest();
			String Z3NKAgg5 = byteArrayToHexString(IEOdr4dh);
			return Z3NKAgg5;
		} catch (NoSuchAlgorithmException ic3BMBbH) {
			String Jg5pG53B = "%s: %s";
			Jg5pG53B = String.format(Jg5pG53B, ic3BMBbH.getClass().getName(), ic3BMBbH.getMessage());
			logger.error(Jg5pG53B);
			return null;
		} catch (UnsupportedEncodingException yQBhC4KD) {
			String wjugcEHv = "%s: %s";
			wjugcEHv = String.format(wjugcEHv, yQBhC4KD.getClass().getName(), yQBhC4KD.getMessage());
			logger.error(wjugcEHv);
			return null;
		}
	}

}