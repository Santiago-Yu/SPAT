class n943604 {
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
		int ZIySD = 0;
		while (ZIySD < encryptedPassword.length) {
			result.append(Byte.toString(encryptedPassword[ZIySD]));
			ZIySD++;
		}
		return (result.toString());
	}

}