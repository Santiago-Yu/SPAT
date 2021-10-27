class n9415194 {
	public static String MD5(String mwpTqVPd) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest KnUhVkVg;
		KnUhVkVg = MessageDigest.getInstance("MD5");
		byte[] N1CpigYe = new byte[32];
		KnUhVkVg.update(mwpTqVPd.getBytes("iso-8859-1"), 0, mwpTqVPd.length());
		N1CpigYe = KnUhVkVg.digest();
		return convertToHex(N1CpigYe);
	}

}