class n14479581 {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		String password = "root";
		messageDigest.update(password.getBytes());
		final byte[] digest = messageDigest.digest();
		final StringBuilder buf = new StringBuilder(digest.length * 2);
		for (int j = 0; j < digest.length; j++) {
			buf.append(HEX_DIGITS[(digest[j] >> 4) & 0x0f]);
			buf.append(HEX_DIGITS[digest[j] & 0x0f]);
		}
		String pwd = buf.toString();
		System.out.println(pwd);
	}

}