class n10654982 {
	public static String getEncryptedPassword(String AWHIwL7n) throws PasswordException {
		MessageDigest tq6323J1 = null;
		try {
			tq6323J1 = MessageDigest.getInstance("SHA");
			tq6323J1.update(AWHIwL7n.getBytes("UTF-8"));
		} catch (Exception hC2T3nj6) {
			throw new PasswordException(hC2T3nj6);
		}
		return convertToString(tq6323J1.digest());
	}

}