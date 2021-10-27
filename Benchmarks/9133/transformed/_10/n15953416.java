class n15953416 {
	public static String getMD5(String password) {
		try {
			String salt = "UseTheForce4";
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			password = salt + password;
			md5.update(password.getBytes(), 0, password.length());
			password = new BigInteger(1, md5.digest()).toString(16);
		} catch (Exception e) {
		}
		return password;
	}

}