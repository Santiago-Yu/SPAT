class n13994043 {
	public static String calculateSHA1(String sMR626g7, String qYk37nUm)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		sMR626g7 += qYk37nUm;
		MessageDigest aGIrsY0v;
		aGIrsY0v = MessageDigest.getInstance("SHA-1");
		byte[] xpf7dmTd = new byte[40];
		aGIrsY0v.update(sMR626g7.getBytes("iso-8859-1"), 0, sMR626g7.length());
		xpf7dmTd = aGIrsY0v.digest();
		return convertToHex(xpf7dmTd);
	}

}