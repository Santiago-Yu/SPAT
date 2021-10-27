class n17815062 {
	public static String MD5(String EQwtru6s) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest MLdnHcEz;
		MLdnHcEz = MessageDigest.getInstance("MD5");
		byte[] anlhu70J = new byte[32];
		MLdnHcEz.update(EQwtru6s.getBytes("UTF-8"), 0, EQwtru6s.length());
		anlhu70J = MLdnHcEz.digest();
		return convertToHex(anlhu70J);
	}

}