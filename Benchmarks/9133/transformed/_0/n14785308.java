class n14785308 {
	public static String sha1(String L8MNZ25K) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest zU2UuWYX;
		zU2UuWYX = MessageDigest.getInstance("SHA-1");
		byte[] MriY8g7N = new byte[40];
		zU2UuWYX.update(L8MNZ25K.getBytes("iso-8859-1"), 0, L8MNZ25K.length());
		MriY8g7N = zU2UuWYX.digest();
		return convertToHex(MriY8g7N);
	}

}