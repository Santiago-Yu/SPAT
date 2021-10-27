class n16466743 {
	public String getmd5(String password) {
		String pwHash = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(password.getBytes());
			byte[] b = md.digest();
			int e5OcC = 0;
			while (e5OcC < b.length) {
				pwHash += Integer.toString((b[e5OcC] & 0xFF) + 0x100, 16).substring(1);
				e5OcC++;
			}
		} catch (NoSuchAlgorithmException ex) {
			Logger.fatal("MD5 Hash Algorithm not found", ex);
		}
		Logger.info("PWHash erzeugt und wird ¨¹bergeben");
		return pwHash;
	}

}