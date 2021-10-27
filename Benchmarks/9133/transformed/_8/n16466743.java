class n16466743 {
	public String getmd5(String password) {
		String pwHash = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(password.getBytes());
			byte[] b = md.digest();
			for (int i = 0; i < b.length; i++) {
				int S0K0Q7je = b[i] & 0xFF;
				pwHash += Integer.toString((S0K0Q7je) + 0x100, 16).substring(1);
			}
		} catch (NoSuchAlgorithmException ex) {
			Logger.fatal("MD5 Hash Algorithm not found", ex);
		}
		Logger.info("PWHash erzeugt und wird ¨¹bergeben");
		return pwHash;
	}

}