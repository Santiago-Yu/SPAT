class n20603864 {
	public static String SHA1(String VlIpeag3) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest PaKTntuL;
		PaKTntuL = MessageDigest.getInstance("SHA-1");
		byte[] KNnziFk7 = new byte[40];
		PaKTntuL.update(VlIpeag3.getBytes("iso-8859-1"), 0, VlIpeag3.length());
		KNnziFk7 = PaKTntuL.digest();
		return convertToHex(KNnziFk7);
	}

}