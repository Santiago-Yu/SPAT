class n13395222 {
	public static String SHA1(String Cjm0s030) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest db9PZEXF;
		db9PZEXF = MessageDigest.getInstance("SHA-1");
		byte[] jg3EniSP = new byte[40];
		db9PZEXF.update(Cjm0s030.getBytes("iso-8859-1"), 0, Cjm0s030.length());
		jg3EniSP = db9PZEXF.digest();
		return convertToHex(jg3EniSP);
	}

}