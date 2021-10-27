class n14624541 {
	public static String convertToSha1(final String wckjTXN7)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest fJgTs4na;
		fJgTs4na = MessageDigest.getInstance("SHA-1");
		byte[] oGb5qKTX = new byte[40];
		fJgTs4na.update(wckjTXN7.getBytes("iso-8859-1"), 0, wckjTXN7.length());
		oGb5qKTX = fJgTs4na.digest();
		return convertToHex(oGb5qKTX);
	}

}