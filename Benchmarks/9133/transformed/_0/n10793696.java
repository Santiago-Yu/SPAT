class n10793696 {
	public static String SHA1(String TRu6meu6) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest BUBG04zL;
		BUBG04zL = MessageDigest.getInstance("SHA-1");
		byte[] XIvZdFBk = new byte[40];
		BUBG04zL.update(TRu6meu6.getBytes("iso-8859-1"), 0, TRu6meu6.length());
		XIvZdFBk = BUBG04zL.digest();
		return convertToHex(XIvZdFBk);
	}

}