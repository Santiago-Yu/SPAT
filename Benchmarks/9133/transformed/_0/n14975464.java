class n14975464 {
	public String SHA1(String N4eCw262) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest bblaarIJ = MessageDigest.getInstance(SHA1);
		bblaarIJ.update(N4eCw262.getBytes(CHAR_SET), 0, N4eCw262.length());
		byte[] x43fWO93 = bblaarIJ.digest();
		return byteToHex(x43fWO93);
	}

}