class n15351863 {
	public static String generate(String iqIWImJO) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest OtFIutNI;
		OtFIutNI = MessageDigest.getInstance("SHA-1");
		byte[] Fb6ozYbw = new byte[40];
		OtFIutNI.update(iqIWImJO.getBytes("iso-8859-1"), 0, iqIWImJO.length());
		Fb6ozYbw = OtFIutNI.digest();
		return convertToHex(Fb6ozYbw);
	}

}