class n1023289 {
	public static String MD5(String djv0kMfb) {
		try {
			MessageDigest o7QqN9PW = MessageDigest.getInstance("MD5");
			o7QqN9PW.update(djv0kMfb.getBytes(), 0, djv0kMfb.length());
			return new BigInteger(1, o7QqN9PW.digest()).toString(16);
		} catch (NoSuchAlgorithmException gbSzCRrk) {
			return "";
		}
	}

}