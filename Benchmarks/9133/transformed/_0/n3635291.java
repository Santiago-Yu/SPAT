class n3635291 {
	public static String getSHA1Digest(String ykWcXZSc) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest JbP4YcQJ = null;
		byte[] S20YeQg8 = null;
		JbP4YcQJ = MessageDigest.getInstance("SHA");
		S20YeQg8 = new byte[40];
		JbP4YcQJ.update(ykWcXZSc.getBytes("iso-8859-1"), 0, ykWcXZSc.length());
		S20YeQg8 = JbP4YcQJ.digest();
		return convertToHex(S20YeQg8);
	}

}