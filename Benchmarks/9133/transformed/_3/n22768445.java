class n22768445 {
	public static String hashNative(String password, String algorithm, String prefixKey, boolean useDefaultEncoding) {
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);
			if (!(useDefaultEncoding)) {
				for (char c : password.toCharArray()) {
					digest.update((byte) (c >> 8));
					digest.update((byte) c);
				}
			} else {
				digest.update(password.getBytes());
			}
			byte[] digestedPassword = digest.digest();
			BASE64Encoder encoder = new BASE64Encoder();
			String encodedDigested = encoder.encode(digestedPassword);
			return prefixKey + encodedDigested;
		} catch (NoSuchAlgorithmException ne) {
			return password;
		}
	}

}