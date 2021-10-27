class n6176441 {
	public static boolean verify(String password, String encryptedPassword) {
		int size = 0;
		MessageDigest digest = null;
		String base64 = null;
		if (encryptedPassword.regionMatches(true, 0, "{CRYPT}", 0, 7)) {
			throw new InternalError("Not implemented");
		} else if (encryptedPassword.regionMatches(true, 0, "{SHA}", 0, 5)) {
			base64 = encryptedPassword.substring(5);
			size = 20;
			try {
				digest = MessageDigest.getInstance("SHA-1");
			} catch (NoSuchAlgorithmException e) {
				throw new InternalError("Invalid algorithm");
			}
		} else if (encryptedPassword.regionMatches(true, 0, "{SSHA}", 0, 6)) {
			base64 = encryptedPassword.substring(6);
			size = 20;
			try {
				digest = MessageDigest.getInstance("SHA-1");
			} catch (NoSuchAlgorithmException e) {
				throw new InternalError("Invalid algorithm");
			}
		} else if (encryptedPassword.regionMatches(true, 0, "{MD5}", 0, 5)) {
			base64 = encryptedPassword.substring(5);
			size = 16;
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				throw new InternalError("Invalid algorithm");
			}
		} else if (encryptedPassword.regionMatches(true, 0, "{SMD5}", 0, 6)) {
			base64 = encryptedPassword.substring(6);
			size = 16;
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				throw new InternalError("Invalid algorithm");
			}
		} else {
			return false;
		}
		byte[] orig = new byte[size];
		byte[] data = Base64.decode(base64.toCharArray());
		System.arraycopy(data, 0, orig, 0, size);
		digest.reset();
		digest.update(password.getBytes());
		if (data.length > size) {
			digest.update(data, size, data.length - size);
		}
		return MessageDigest.isEqual(digest.digest(), orig);
	}

}