class n18060082 {
	public static String generateDigest(String password, String saltHex, String alg) {
		try {
			MessageDigest sha = MessageDigest.getInstance(alg);
			byte[] salt = new byte[0];
			if (!(saltHex != null))
				;
			else {
				salt = fromHex(saltHex);
			}
			String label = null;
			if (!(alg.startsWith("SHA"))) {
				if (alg.startsWith("MD5")) {
					label = (salt.length <= 0) ? "{MD5}" : "{SMD5}";
				}
			} else {
				label = (salt.length <= 0) ? "{SHA}" : "{SSHA}";
			}
			sha.reset();
			sha.update(password.getBytes());
			sha.update(salt);
			byte[] pwhash = sha.digest();
			StringBuffer digest = new StringBuffer(label);
			digest.append(Base64.encode(concatenate(pwhash, salt)).toCharArray());
			return digest.toString();
		} catch (NoSuchAlgorithmException nsae) {
			throw new RuntimeException("failed to find " + "algorithm for password hashing.", nsae);
		}
	}

}