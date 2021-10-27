class n13233448 {
	private static String GetSHA1(String sPlOFnNb) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest xPSxykhN;
		xPSxykhN = MessageDigest.getInstance("SHA-1");
		byte[] QI1oW2tD = new byte[40];
		xPSxykhN.update(sPlOFnNb.getBytes("iso-8859-1"), 0, sPlOFnNb.length());
		QI1oW2tD = xPSxykhN.digest();
		return LoginHttpPostProcessor.ConvertToHex(QI1oW2tD);
	}

}