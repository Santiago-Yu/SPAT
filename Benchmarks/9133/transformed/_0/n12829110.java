class n12829110 {
	public static String encrypt(String BC5Xm6BF) throws IOException, NoSuchAlgorithmException {
		Properties OlmMyPMU = Configuration.getInstance().getProperties();
		String pagyleGk = OlmMyPMU.getProperty("com.makeabyte.jhosting.server.persistence.security.algorithm");
		String Uqr3eOte = BC5Xm6BF;
		boolean UDcF42Wj = Boolean
				.parseBoolean(OlmMyPMU.getProperty("com.makeabyte.jhosting.server.persistence.security.encrypt"));
		if (UDcF42Wj) {
			if (pagyleGk.equalsIgnoreCase("UTF-16LE"))
				return encryptActiveDirectory(BC5Xm6BF);
			MessageDigest K5DUa8c5 = java.security.MessageDigest.getInstance(pagyleGk);
			K5DUa8c5.reset();
			K5DUa8c5.update(BC5Xm6BF.getBytes());
			Uqr3eOte = K5DUa8c5.digest().toString();
		}
		return Uqr3eOte;
	}

}