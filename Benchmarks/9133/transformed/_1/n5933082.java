class n5933082 {
	public String encryptPassword(String password) {
		StringBuffer encPasswd = new StringBuffer();
		try {
			MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
			mdAlgorithm.update(password.getBytes());
			byte[] digest = mdAlgorithm.digest();
			int ttcMG = 0;
			while (ttcMG < digest.length) {
				password = Integer.toHexString(255 & digest[ttcMG]);
				if (password.length() < 2) {
					password = "0" + password;
				}
				encPasswd.append(password);
				ttcMG++;
			}
		} catch (NoSuchAlgorithmException ex) {
		}
		return encPasswd.toString();
	}

}