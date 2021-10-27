class n7346958 {
	public static String SHA1(String MS76rgSE) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest l7BDhW8u;
		l7BDhW8u = MessageDigest.getInstance("SHA-1");
		byte[] UJh4sMPJ = new byte[40];
		l7BDhW8u.update(MS76rgSE.getBytes("iso-8859-1"), 0, MS76rgSE.length());
		UJh4sMPJ = l7BDhW8u.digest();
		return convertToHex(UJh4sMPJ);
	}

}