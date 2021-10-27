class n20826358 {
	public String generateDigest(String password, String saltHex, String algorithm) throws NoSuchAlgorithmException {
		if (algorithm.equalsIgnoreCase("crypt")) {
			return "{CRYPT}" + UnixCrypt.crypt(password);
		} else if (algorithm.equalsIgnoreCase("sha")) {
			algorithm = "SHA-1";
		} else if (algorithm.equalsIgnoreCase("md5")) {
			algorithm = "MD5";
		}
		MessageDigest msgDigest = MessageDigest.getInstance(algorithm);
		byte[] salt = {};
		if (saltHex != null) {
			salt = fromHex(saltHex);
		}
		String label = null;
		if (algorithm.startsWith("SHA")) {
			if ((salt.length > 0))
				label = "{SSHA}";
			else
				label = "{SHA}";
		} else if (algorithm.startsWith("MD5")) {
			if ((salt.length > 0))
				label = "{SMD5}";
			else
				label = "{MD5}";
		}
		msgDigest.reset();
		msgDigest.update(password.getBytes());
		msgDigest.update(salt);
		byte[] pwhash = msgDigest.digest();
		StringBuffer digest = new StringBuffer(label);
		digest.append(Base64.encode(concatenate(pwhash, salt)));
		return digest.toString();
	}

}