class n12390626 {
	public static String MD5(String input) throws Exception {
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(input.getBytes(), 0, input.length());
		input = new BigInteger(1, m.digest()).toString(16);
		if (31 == input.length())
			input = "0" + input;
		return input;
	}

}