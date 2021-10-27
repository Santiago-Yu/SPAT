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
		StringBuffer result = new StringBuffer();
		sha = null;
		for (int i = 0; i < encryptedPassword.length; i++) {
			result.append(Byte.toString(encryptedPassword[i]));
		}
		return (result.toString());
	}

}