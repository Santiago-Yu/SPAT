class n16556715 {
	public boolean checkPassword(String password, String digest) {
		MessageDigest sha = null;
		boolean passwordMatch = false;
		try {
			if (digest.regionMatches(true, 0, "{SHA}", 0, 5)) {
				digest = digest.substring(5);
			} else if (digest.regionMatches(true, 0, "{SSHA}", 0, 6)) {
				digest = digest.substring(6);
			}
			sha = MessageDigest.getInstance("SHA-1");
			byte[][] hs = split(Base64.decode(digest.getBytes()), 20);
			byte[] hash = hs[0];
			byte[] salt = hs[1];
			sha.reset();
			sha.update(password.getBytes());
			sha.update(salt);
			byte[] pwhash = sha.digest();
			if (MessageDigest.isEqual(hash, pwhash)) {
				passwordMatch = true;
			}
		} catch (NoSuchAlgorithmException nsae) {
			CofaxToolsUtil.log("Algorithme SHA-1 non supporte a la verification du password" + nsae + id);
		}
		return passwordMatch;
	}

}