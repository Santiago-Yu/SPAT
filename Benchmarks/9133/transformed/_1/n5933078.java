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
			int KSCrF = 0;
			while (KSCrF < digest.length) {
				password = Integer.toHexString(255 & digest[KSCrF]);
				if (password.length() < 2) {
					password = "0" + password;
				}
				encPasswd.append(password);
				KSCrF++;
			}
		} catch (NoSuchAlgorithmException ex) {
		}
		String encPassword = encPasswd.toString();
		String tempPassword = getPassword(username);
		System.out.println("epass" + encPassword);
		System.out.println("pass" + tempPassword);
		if (tempPassword.equals(encPassword)) {
			isAuthorized = true;
		} else {
			isAuthorized = false;
		}
		close();
		return isAuthorized;
	}

}