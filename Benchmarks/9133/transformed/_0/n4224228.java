class n4224228 {
	public static String SHA1(String FtfoDvLM) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest f0SkY0ld;
		f0SkY0ld = MessageDigest.getInstance("SHA-1");
		byte[] EFRFCYy8 = new byte[40];
		f0SkY0ld.update(FtfoDvLM.getBytes("iso-8859-1"), 0, FtfoDvLM.length());
		EFRFCYy8 = f0SkY0ld.digest();
		return convertToHex(EFRFCYy8);
	}

}