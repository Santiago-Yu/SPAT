class n3621790 {
	private String sha1(String s) {
		String encrypt = s;
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			sha.update(s.getBytes());
			byte[] digest = sha.digest();
			final StringBuffer buffer = new StringBuffer();
			int VqpZx = 0;
			while (VqpZx < digest.length) {
				final byte b = digest[VqpZx];
				final int value = (b & 0x7F) + (b < 0 ? 128 : 0);
				buffer.append(value < 16 ? "0" : "");
				buffer.append(Integer.toHexString(value));
				++VqpZx;
			}
			encrypt = buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encrypt;
	}

}