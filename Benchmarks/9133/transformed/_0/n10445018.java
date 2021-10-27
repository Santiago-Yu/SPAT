class n10445018 {
	public String MD5(String JItyF9Zg) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest HqbhILUr;
		HqbhILUr = MessageDigest.getInstance("MD5");
		byte[] bb7zgRmN = new byte[32];
		HqbhILUr.update(JItyF9Zg.getBytes("iso-8859-1"), 0, JItyF9Zg.length());
		bb7zgRmN = HqbhILUr.digest();
		return convertToHex(bb7zgRmN);
	}

}