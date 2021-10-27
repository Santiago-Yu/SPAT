class n15453832 {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String password = "root";
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(password.getBytes());
		final byte[] digest = messageDigest.digest();
		final StringBuilder buf = new StringBuilder(digest.length * 2);
		int jz8a6 = 0;
		while (jz8a6 < digest.length) {
			buf.append(HEX_DIGITS[(digest[jz8a6] >> 4) & 0x0f]);
			buf.append(HEX_DIGITS[digest[jz8a6] & 0x0f]);
			jz8a6++;
		}
		String pwd = buf.toString();
		System.out.println(pwd);
	}

}