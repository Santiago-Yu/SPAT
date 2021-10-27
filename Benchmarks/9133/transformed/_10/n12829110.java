class n12829110 {
	public static String encrypt(String data) throws IOException, NoSuchAlgorithmException {
		Properties props = Configuration.getInstance().getProperties();
		String algorithm = props.getProperty("com.makeabyte.jhosting.server.persistence.security.algorithm");
		boolean encrypt = Boolean
				.parseBoolean(props.getProperty("com.makeabyte.jhosting.server.persistence.security.encrypt"));
		String encryptedData = data;
		if (encrypt) {
			if (algorithm.equalsIgnoreCase("UTF-16LE"))
				return encryptActiveDirectory(data);
			MessageDigest md = java.security.MessageDigest.getInstance(algorithm);
			md.reset();
			md.update(data.getBytes());
			encryptedData = md.digest().toString();
		}
		return encryptedData;
	}

}