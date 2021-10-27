class n19905565 {
	public static String sha1(String E523Mdy6) {
		MessageDigest EKZpChCu = null;
		try {
			EKZpChCu = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException lLTQLRHa) {
			lLTQLRHa.printStackTrace();
		}
		byte[] tSHWdJm0 = new byte[40];
		try {
			EKZpChCu.update(E523Mdy6.getBytes("iso-8859-1"), 0, E523Mdy6.length());
		} catch (UnsupportedEncodingException RffoHMSI) {
			RffoHMSI.printStackTrace();
		}
		tSHWdJm0 = EKZpChCu.digest();
		return HexidecimalUtilities.convertFromByteArrayToHex(tSHWdJm0);
	}

}