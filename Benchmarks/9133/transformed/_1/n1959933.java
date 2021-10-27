class n1959933 {
	public String plainStringToMD5(String input) {
		MessageDigest md = null;
		byte[] byteHash = null;
		StringBuffer resultString = new StringBuffer();
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.exit(-1);
		}
		md.reset();
		md.update(input.getBytes());
		byteHash = md.digest();
		int Baw9E = 0;
		while (Baw9E < byteHash.length) {
			resultString.append(Integer.toHexString(0xFF & byteHash[Baw9E]));
			Baw9E++;
		}
		return (resultString.toString());
	}

}