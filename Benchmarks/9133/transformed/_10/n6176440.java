class n6176440 {
	public static String encrypt(String password, String algorithm, byte[] salt) {
		MessageDigest digest = null;
		StringBuffer buffer = new StringBuffer();
		int size = 0;
		if ("CRYPT".equalsIgnoreCase(algorithm)) {
			throw new InternalError("Not implemented");
		} else if ("SHA".equalsIgnoreCase(algorithm) || "SSHA".equalsIgnoreCase(algorithm)) {
			if (salt != null && salt.length > 0) {
				buffer.append("{SSHA}");
			} else {
				buffer.append("{SHA}");
			}
			size = 20;
			try {
				digest = MessageDigest.getInstance("SHA-1");
			} catch (NoSuchAlgorithmException e) {
				throw new InternalError("Invalid algorithm");
			}
		} else if ("MD5".equalsIgnoreCase(algorithm) || "SMD5".equalsIgnoreCase(algorithm)) {
			if (salt != null && salt.length > 0) {
				buffer.append("{SMD5}");
			} else {
				buffer.append("{MD5}");
			}
			size = 16;
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				throw new InternalError("Invalid algorithm");
			}
		}
		int outSize = size;
		digest.reset();
		digest.update(password.getBytes());
		if (salt != null && salt.length > 0) {
			digest.update(salt);
			outSize += salt.length;
		}
		byte[] out = new byte[outSize];
		System.arraycopy(digest.digest(), 0, out, 0, size);
		if (salt != null && salt.length > 0) {
			System.arraycopy(salt, 0, out, size, salt.length);
		}
		buffer.append(Base64.encode(out));
		return buffer.toString();
	}

}