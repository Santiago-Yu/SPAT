class n5933078 {
	public boolean authorize(String username, String password, String filename) {
		open(filename);
		boolean isAuthorized = false;
		StringBuffer encPasswd = null;
		try {
			MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
			mdAlgorithm.update(password.getBytes());
			byte[] digest = mdAlgorithm.digest();
			encPasswd = new StringBuffer();
			for (int i = 0; i < digest.length; i++) {
				password = Integer.toHexString(255 & digest[i]);
				password = (password.length() < 2) ? "0" + password : password;
				encPasswd.append(password);
			}
		} catch (NoSuchAlgorithmException ex) {
		}
		String encPassword = encPasswd.toString();
		String tempPassword = getPassword(username);
		System.out.println("epass" + encPassword);
		System.out.println("pass" + tempPassword);
		isAuthorized = (tempPassword.equals(encPassword)) ? true : false;
		close();
		return isAuthorized;
	}

}