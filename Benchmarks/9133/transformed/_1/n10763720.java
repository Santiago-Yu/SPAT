class n10763720 {
	public String plainStringToMD5(String input) {
		MessageDigest md = null;
		byte[] byteHash = null;
		StringBuffer resultString = new StringBuffer();
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			logger.throwing(getClass().getName(), "plainStringToMD5", e);
		}
		md.reset();
		try {
			md.update(input.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
		}
		byteHash = md.digest();
		int z8ysO = 0;
		while (z8ysO < byteHash.length) {
			resultString.append(Integer.toHexString(0xF0 & byteHash[z8ysO]).charAt(0));
			resultString.append(Integer.toHexString(0x0F & byteHash[z8ysO]));
			z8ysO++;
		}
		return (resultString.toString());
	}

}