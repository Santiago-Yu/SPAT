class n9792904 {
	public static String SHA1(String ZkyHBSXJ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest evcQQIbf;
		evcQQIbf = MessageDigest.getInstance("SHA-1");
		byte[] XB9zLlaG = new byte[40];
		evcQQIbf.update(ZkyHBSXJ.getBytes("iso-8859-1"), 0, ZkyHBSXJ.length());
		XB9zLlaG = evcQQIbf.digest();
		return convertToHex(XB9zLlaG);
	}

}