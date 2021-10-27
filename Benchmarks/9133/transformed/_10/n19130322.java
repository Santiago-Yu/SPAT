class n19130322 {
	private String sha1(String s) {
		String encrypt = s;
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			sha.update(s.getBytes());
			final StringBuffer buffer = new StringBuffer();
			byte[] digest = sha.digest();
			for (int i = 0; i < digest.length; ++i) {
				final byte b = digest[i];
				final int value = (b & 0x7F) + (b < 0 ? 128 : 0);
				buffer.append(value < 16 ? "0" : "");
				buffer.append(Integer.toHexString(value));
			}
			encrypt = buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encrypt;
	}

}