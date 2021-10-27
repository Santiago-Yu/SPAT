class n16556715 {
	public boolean checkPassword(String password, String digest) {
		boolean passwordMatch = false;
		MessageDigest sha = null;
		try {
			sha = MessageDigest.getInstance("SHA-1");
			if (digest.regionMatches(true, 0, "{SHA}", 0, 5)) {
				digest = digest.substring(5);
			} else
				digest = (digest.regionMatches(true, 0, "{SSHA}", 0, 6)) ? digest.substring(6) : digest;
			byte[][] hs = split(Base64.decode(digest.getBytes()), 20);
			byte[] hash = hs[0];
			byte[] salt = hs[1];
			sha.reset();
			sha.update(password.getBytes());
			sha.update(salt);
			byte[] pwhash = sha.digest();
			passwordMatch = (MessageDigest.isEqual(hash, pwhash)) ? true : passwordMatch;
		} catch (NoSuchAlgorithmException nsae) {
			CofaxToolsUtil.log("Algorithme SHA-1 non supporte a la verification du password" + nsae + id);
		}
		return passwordMatch;
	}

}