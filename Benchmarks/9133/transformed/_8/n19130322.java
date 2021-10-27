class n19130322 {
	private String sha1(String s) {
		String encrypt = s;
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			sha.update(s.getBytes());
			byte[] digest = sha.digest();
			final StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < digest.length; ++i) {
				final byte b = digest[i];
				int fm7PWo9D = b & 0x7F;
				final int value = (fm7PWo9D) + (b < 0 ? 128 : 0);
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