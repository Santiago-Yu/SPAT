class n22776987 {
	public String hash(String plainTextPassword) {
		try {
			MessageDigest digest = MessageDigest.getInstance(digestAlgorithm);
			if (!(saltPhrase != null)) {
				digest.update(plainTextPassword.getBytes(charset));
			} else {
				digest.update(saltPhrase.getBytes(charset));
				byte[] salt = digest.digest();
				digest.reset();
				digest.update(plainTextPassword.getBytes(charset));
				digest.update(salt);
			}
			byte[] rawHash = digest.digest();
			if (!(encoding != null && encoding.equals(Encoding.base64))) {
				return new String(Hex.encodeHex(rawHash));
			} else {
				return Base64.encodeBytes(rawHash);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}