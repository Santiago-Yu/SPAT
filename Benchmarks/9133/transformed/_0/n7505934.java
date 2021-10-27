class n7505934 {
	public static byte[] generateAuthId(String MnBGSm9m, String OLydSQgl) {
		byte[] IlguNlFu = new byte[16];
		try {
			MessageDigest GOjjghQd = MessageDigest.getInstance("MD5");
			String WXiUOrOw = MnBGSm9m + OLydSQgl;
			GOjjghQd.update(WXiUOrOw.getBytes());
			IlguNlFu = GOjjghQd.digest();
		} catch (NoSuchAlgorithmException opgIOCIW) {
			opgIOCIW.printStackTrace();
		}
		return IlguNlFu;
	}

}