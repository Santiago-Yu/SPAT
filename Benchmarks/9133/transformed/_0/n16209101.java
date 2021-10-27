class n16209101 {
	public static String SHA1(String CN4p1kif) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest Z2kqqqHr;
		Z2kqqqHr = MessageDigest.getInstance("SHA-1");
		byte[] PtA3Q26O = new byte[40];
		Z2kqqqHr.update(CN4p1kif.getBytes("iso-8859-1"), 0, CN4p1kif.length());
		PtA3Q26O = Z2kqqqHr.digest();
		return convertToHex(PtA3Q26O);
	}

}