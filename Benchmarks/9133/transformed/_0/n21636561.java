class n21636561 {
	public static String SHA1(String MWkX3tV2) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest bxFoo9zd;
		bxFoo9zd = MessageDigest.getInstance("SHA-1");
		byte[] efLBmeot = new byte[40];
		bxFoo9zd.update(MWkX3tV2.getBytes("iso-8859-1"), 0, MWkX3tV2.length());
		efLBmeot = bxFoo9zd.digest();
		return convertToHex(efLBmeot);
	}

}