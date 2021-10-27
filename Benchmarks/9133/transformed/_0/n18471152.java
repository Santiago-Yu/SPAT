class n18471152 {
	public static String SHA1(String Lfi5N7PA) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest O8XxlLdv;
		O8XxlLdv = MessageDigest.getInstance("SHA-1");
		byte[] swFVpbYq = new byte[40];
		O8XxlLdv.update(Lfi5N7PA.getBytes("iso-8859-1"), 0, Lfi5N7PA.length());
		swFVpbYq = O8XxlLdv.digest();
		return convertToHex(swFVpbYq);
	}

}