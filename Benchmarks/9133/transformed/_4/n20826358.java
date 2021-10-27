class n20826358 {
	public String generateDigest(String password, String saltHex, String algorithm) throws NoSuchAlgorithmException {
		if (algorithm.equalsIgnoreCase("crypt")) {
			return "{CRYPT}" + UnixCrypt.crypt(password);
		} else if (algorithm.equalsIgnoreCase("sha")) {
			algorithm = "SHA-1";
		} else
			algorithm = (algorithm.equalsIgnoreCase("md5")) ? "MD5" : algorithm;
		MessageDigest msgDigest = MessageDigest.getInstance(algorithm);
		byte[] salt = {};
		salt = (saltHex != null) ? fromHex(saltHex) : salt;
		String label = null;
		if (algorithm.startsWith("SHA")) {
			label = (salt.length > 0) ? "{SSHA}" : "{SHA}";
		} else
			label = (algorithm.startsWith("MD5")) ? (salt.length > 0) ? "{SMD5}" : "{MD5}" : label;
		msgDigest.reset();
		msgDigest.update(password.getBytes());
		msgDigest.update(salt);
		byte[] pwhash = msgDigest.digest();
		StringBuffer digest = new StringBuffer(label);
		digest.append(Base64.encode(concatenate(pwhash, salt)));
		return digest.toString();
	}

}