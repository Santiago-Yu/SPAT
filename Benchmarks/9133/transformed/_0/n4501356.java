class n4501356 {
	static String calculateProfileDiffDigest(String TXTgYLp5, boolean HkNnRZrE) throws Exception {
		if (HkNnRZrE) {
			TXTgYLp5 = removeWhitespaces(TXTgYLp5);
		}
		MessageDigest mWRUUEEM = MessageDigest.getInstance("MD5");
		mWRUUEEM.update(TXTgYLp5.getBytes());
		return new BASE64Encoder().encode(mWRUUEEM.digest());
	}

}