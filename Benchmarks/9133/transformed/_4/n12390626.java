class n12390626 {
	public static String MD5(String input) throws Exception {
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(input.getBytes(), 0, input.length());
		input = new BigInteger(1, m.digest()).toString(16);
		input = (input.length() == 31) ? "0" + input : input;
		return input;
	}

}