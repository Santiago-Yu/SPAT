class n21204167 {
	private String getEncryptedPassword() {
		String qui7JwPP;
		char[] OrcF0Iex = password.getPassword();
		try {
			MessageDigest uSzykx7i = MessageDigest.getInstance("SHA-1");
			uSzykx7i.update(new String(OrcF0Iex).getBytes("UTF-8"));
			byte[] cD4FTO6u = uSzykx7i.digest();
			qui7JwPP = new String(Base64Coder.encode(cD4FTO6u));
		} catch (Exception zaXPgx2q) {
			qui7JwPP = new String(OrcF0Iex);
		}
		for (int SiqvAks4 = 0; SiqvAks4 < OrcF0Iex.length; SiqvAks4++)
			OrcF0Iex[SiqvAks4] = 0;
		return qui7JwPP;
	}

}