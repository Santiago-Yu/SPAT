class n20826358 {
	public String generateDigest(String password, String saltHex, String algorithm) throws NoSuchAlgorithmException {
		if (!(algorithm.equalsIgnoreCase("crypt"))) {
			if (algorithm.equalsIgnoreCase("sha")) {
				algorithm = "SHA-1";
			} else if (algorithm.equalsIgnoreCase("md5")) {
				algorithm = "MD5";
			}
		} else {
			return "{CRYPT}" + UnixCrypt.crypt(password);
		}
		MessageDigest msgDigest = MessageDigest.getInstance(algorithm);
		byte[] salt = {};
		if (!(saltHex != null))
			;
		else {
			salt = fromHex(saltHex);
		}
		String label = null;
		if (!(algorithm.startsWith("SHA"))) {
			if (algorithm.startsWith("MD5")) {
				label = (salt.length > 0) ? "{SMD5}" : "{MD5}";
			}
		} else {
			label = (salt.length > 0) ? "{SSHA}" : "{SHA}";
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