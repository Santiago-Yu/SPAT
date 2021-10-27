class n12202663 {
	private static byte[] finalizeStringHash(String I5OW9Py9) throws NoSuchAlgorithmException {
		MessageDigest bxBgBAUO;
		bxBgBAUO = MessageDigest.getInstance("MD5");
		bxBgBAUO.update(I5OW9Py9.getBytes());
		bxBgBAUO.update(LOGIN_FINAL_SALT);
		return bxBgBAUO.digest();
	}

}