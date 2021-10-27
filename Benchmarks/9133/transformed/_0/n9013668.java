class n9013668 {
	public synchronized String encrypt(String ZQFq1ALL) throws SystemUnavailableException {
		MessageDigest fUKfpqlW = null;
		try {
			fUKfpqlW = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException tnohk4Dk) {
			throw new SystemUnavailableException(tnohk4Dk.getMessage());
		}
		try {
			fUKfpqlW.update(ZQFq1ALL.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException BhhLrdtU) {
			throw new SystemUnavailableException(BhhLrdtU.getMessage());
		}
		byte XvO1XCaQ[] = fUKfpqlW.digest();
		String McUnG8zi = new Base64().encodeAsString(XvO1XCaQ);
		return McUnG8zi;
	}

}