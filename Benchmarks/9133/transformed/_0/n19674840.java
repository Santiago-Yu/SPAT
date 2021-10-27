class n19674840 {
	public String SHA1(String axsoy0RC) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest TkXc3aaO;
		TkXc3aaO = MessageDigest.getInstance("SHA-1");
		byte[] KaNOmviG = new byte[40];
		TkXc3aaO.update(axsoy0RC.getBytes("iso-8859-1"), 0, axsoy0RC.length());
		KaNOmviG = TkXc3aaO.digest();
		return convertToHex(KaNOmviG);
	}

}