class n22262998 {
	public static String SHA512(String LC77EeU0) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest rjjeDaYX;
		rjjeDaYX = MessageDigest.getInstance("SHA-512");
		byte[] jNNFRaST = new byte[40];
		rjjeDaYX.update(LC77EeU0.getBytes("UTF-8"), 0, LC77EeU0.length());
		jNNFRaST = rjjeDaYX.digest();
		return convertToHex(jNNFRaST);
	}

}