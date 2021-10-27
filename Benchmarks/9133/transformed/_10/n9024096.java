class n9024096 {
	public static final String enCode(String algorithm, String string) {
		String result = "";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance(algorithm);
			md.update(string.getBytes());
			result = binaryToString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

}