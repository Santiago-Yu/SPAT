class n9594116 {
	public static String hash(String arg) throws NoSuchAlgorithmException {
		String input = arg;
		MessageDigest md = MessageDigest.getInstance("SHA");
		String output;
		md.update(input.getBytes());
		output = Hex.encodeHexString(md.digest());
		return output;
	}

}