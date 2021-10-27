class n4235407 {
	protected static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		String s = salt + password;
		md.update(s.getBytes());
		byte bs[] = md.digest();
		String s1 = BASE64Encoder.encode(bs);
		return new StringBuffer(salt).append(':').append(s1).toString();
	}

}