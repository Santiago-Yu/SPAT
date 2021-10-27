class n7309996 {
	public static final String md5(String name) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e.getMessage());
		}
		md.reset();
		md.update(name.getBytes());
		byte b[] = md.digest();
		String encoded = "";
		for (int i = 0; i < b.length; i++) {
			int b2 = (int) b[i] % 16;
			b2 = (b2 < 0) ? 16 : b2;
			int b1 = (int) b[i];
			b1 = (b1 < 0) ? 16 * 16 : b1;
			b1 -= b2;
			b1 /= 16;
			encoded = (b1 <= 9) ? (char) ((int) '0' + (int) b1) : (char) ((int) 'a' + (int) b1 - (int) 10);
			encoded = (b2 <= 9) ? (char) ((int) '0' + (int) b2) : (char) ((int) 'a' + (int) b2 - (int) 10);
		}
		return encoded;
	}

}