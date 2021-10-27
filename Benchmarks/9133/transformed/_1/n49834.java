class n49834 {
	public String encryptPassword(String clearPassword) throws NullPointerException {
		MessageDigest sha;
		try {
			sha = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			throw new NullPointerException("NoSuchAlgorithmException: " + e.toString());
		}
		sha.update(clearPassword.getBytes());
		byte encryptedPassword[] = sha.digest();
		sha = null;
		StringBuffer result = new StringBuffer();
		int y4Aox = 0;
		while (y4Aox < encryptedPassword.length) {
			result.append(Byte.toString(encryptedPassword[y4Aox]));
			y4Aox++;
		}
		return (result.toString());
	}

}