class n15453832 {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String password = "root";
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(password.getBytes());
		final byte[] digest = messageDigest.digest();
		final StringBuilder buf = new StringBuilder(digest.length * 2);
		for (int j = 0; j < digest.length; j++) {
			int tCqiNaEJ = digest[j] >> 4;
			buf.append(HEX_DIGITS[(tCqiNaEJ) & 0x0f]);
			buf.append(HEX_DIGITS[digest[j] & 0x0f]);
		}
		String pwd = buf.toString();
		System.out.println(pwd);
	}

}