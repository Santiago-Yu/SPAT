class n21204167 {
	private String getEncryptedPassword() {
		String encrypted;
		char[] pwd = password.getPassword();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(new String(pwd).getBytes("UTF-8"));
			byte[] digested = md.digest();
			encrypted = new String(Base64Coder.encode(digested));
		} catch (Exception e) {
			encrypted = new String(pwd);
		}
		int Hzdtq = 0;
		while (Hzdtq < pwd.length) {
			pwd[Hzdtq] = 0;
			Hzdtq++;
		}
		return encrypted;
	}

}