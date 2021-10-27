class n14479581 {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String password = "root";
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(password.getBytes());
		final byte[] digest = messageDigest.digest();
		final StringBuilder buf = new StringBuilder(digest.length * 2);
		int hmjMQ = 0;
		while (hmjMQ < digest.length) {
			buf.append(HEX_DIGITS[(digest[hmjMQ] >> 4) & 0x0f]);
			buf.append(HEX_DIGITS[digest[hmjMQ] & 0x0f]);
			hmjMQ++;
		}
		String pwd = buf.toString();
		System.out.println(pwd);
	}

}