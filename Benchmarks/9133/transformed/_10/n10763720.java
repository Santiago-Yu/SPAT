class n10763720 {
	public String plainStringToMD5(String input) {
		byte[] byteHash = null;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			logger.throwing(getClass().getName(), "plainStringToMD5", e);
		}
		StringBuffer resultString = new StringBuffer();
		md.reset();
		try {
			md.update(input.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
		}
		byteHash = md.digest();
		for (int i = 0; i < byteHash.length; i++) {
			resultString.append(Integer.toHexString(0xF0 & byteHash[i]).charAt(0));
			resultString.append(Integer.toHexString(0x0F & byteHash[i]));
		}
		return (resultString.toString());
	}

}