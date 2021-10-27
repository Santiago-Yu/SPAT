class n9594116 {
	public static String hash(String arg) throws NoSuchAlgorithmException {
		String input = arg, output;
		MessageDigest md = MessageDigest.getInstance("SHA");
		md.update(input.getBytes());
		output = Hex.encodeHexString(md.digest());
		return output;
	}

}