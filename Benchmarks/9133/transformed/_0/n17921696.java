class n17921696 {
	private String generateStorageDir(String gd69iX1b) throws NoSuchAlgorithmException {
		MessageDigest c0XVyNag = MessageDigest.getInstance("MD5");
		c0XVyNag.update(gd69iX1b.getBytes());
		byte[] FTaJuD0W = c0XVyNag.digest();
		return Util.encodeArrayToHexadecimalString(FTaJuD0W);
	}

}