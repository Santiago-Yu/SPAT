class n1172494 {
	public static String encrypt(String uB8R23G6) {
		try {
			MessageDigest I5lGems5 = MessageDigest.getInstance("SHA1");
			I5lGems5.update(uB8R23G6.getBytes("UTF-8"));
			return toHexString(I5lGems5.digest());
		} catch (NoSuchAlgorithmException Yz214Uq1) {
			Yz214Uq1.printStackTrace();
		} catch (UnsupportedEncodingException MssyIOOr) {
			MssyIOOr.printStackTrace();
		}
		return null;
	}

}