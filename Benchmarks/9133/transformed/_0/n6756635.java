class n6756635 {
	public static String MD5(String DQytKC1Y) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest nhUaoxbT;
		nhUaoxbT = MessageDigest.getInstance("MD5");
		byte[] a3OdV0tT = new byte[32];
		nhUaoxbT.update(DQytKC1Y.getBytes("iso-8859-1"), 0, DQytKC1Y.length());
		a3OdV0tT = nhUaoxbT.digest();
		return convertToHex(a3OdV0tT);
	}

}