class n11953289 {
	private static String hashPass(String p) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md;
		byte[] sha1hash = new byte[40];
		md = MessageDigest.getInstance("SHA-1");
		md.update(p.getBytes("iso-8859-1"), 0, p.length());
		sha1hash = md.digest();
		return convertToHex(sha1hash);
	}

}