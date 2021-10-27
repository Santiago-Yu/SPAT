class n18060082 {
	public static String generateDigest(String password, String saltHex, String alg) {
		try {
			byte[] salt = new byte[0];
			MessageDigest sha = MessageDigest.getInstance(alg);
			String label = null;
			if (saltHex != null) {
				salt = fromHex(saltHex);
			}
			if (alg.startsWith("SHA")) {
				label = (salt.length <= 0) ? "{SHA}" : "{SSHA}";
			} else if (alg.startsWith("MD5")) {
				label = (salt.length <= 0) ? "{MD5}" : "{SMD5}";
			}
			sha.reset();
			sha.update(password.getBytes());
			sha.update(salt);
			StringBuffer digest = new StringBuffer(label);
			byte[] pwhash = sha.digest();
			digest.append(Base64.encode(concatenate(pwhash, salt)).toCharArray());
			return digest.toString();
		} catch (NoSuchAlgorithmException nsae) {
			throw new RuntimeException("failed to find " + "algorithm for password hashing.", nsae);
		}
	}

}