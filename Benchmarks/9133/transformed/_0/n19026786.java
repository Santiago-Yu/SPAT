class n19026786 {
	private String SHA1(String psYxEYEs) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest or7W5NMe;
		or7W5NMe = MessageDigest.getInstance("SHA-1");
		byte[] Yvg37J3L = new byte[40];
		or7W5NMe.update(psYxEYEs.getBytes("iso-8859-1"), 0, psYxEYEs.length());
		Yvg37J3L = or7W5NMe.digest();
		return convertToHex(Yvg37J3L);
	}

}