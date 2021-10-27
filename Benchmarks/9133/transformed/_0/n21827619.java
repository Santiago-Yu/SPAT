class n21827619 {
	public static String SHA1(String ZJ6Q3vfO) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest qMyXirtn;
		qMyXirtn = MessageDigest.getInstance("SHA-1");
		byte[] FpDQ23Tu = new byte[40];
		qMyXirtn.update(ZJ6Q3vfO.getBytes("iso-8859-1"), 0, ZJ6Q3vfO.length());
		FpDQ23Tu = qMyXirtn.digest();
		return convertToHex(FpDQ23Tu);
	}

}