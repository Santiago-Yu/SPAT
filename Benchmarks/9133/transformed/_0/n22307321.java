class n22307321 {
	public static String crypt(String xqd7Jpj4) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest mGXHKOP5 = MessageDigest.getInstance("MD5");
		mGXHKOP5.update(xqd7Jpj4.getBytes("UTF-16"));
		BigInteger xHU4WE4O = new BigInteger(1, mGXHKOP5.digest(key.getBytes()));
		return xHU4WE4O.toString(16);
	}

}