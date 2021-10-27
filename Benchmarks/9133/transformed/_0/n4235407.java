class n4235407 {
	protected static String hashPassword(String KB8guxv1, String GdIS6CXf) throws NoSuchAlgorithmException {
		String MyzObhJ4 = GdIS6CXf + KB8guxv1;
		MessageDigest OvsJtYQl = MessageDigest.getInstance("MD5");
		OvsJtYQl.update(MyzObhJ4.getBytes());
		byte tRf7qfKB[] = OvsJtYQl.digest();
		String LUn8Z9GL = BASE64Encoder.encode(tRf7qfKB);
		return new StringBuffer(GdIS6CXf).append(':').append(LUn8Z9GL).toString();
	}

}