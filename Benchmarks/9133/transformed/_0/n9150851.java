class n9150851 {
	public static String encrypt(String pVeCqhlg) {
		MessageDigest heMxamgM;
		try {
			heMxamgM = MessageDigest.getInstance("MD5");
			byte[] YBxUXMJB = new byte[32];
			heMxamgM.update(pVeCqhlg.getBytes("UTF-8"), 0, pVeCqhlg.length());
			YBxUXMJB = heMxamgM.digest();
			return convertToHex(YBxUXMJB);
		} catch (NoSuchAlgorithmException bOoGtwJu) {
			bOoGtwJu.printStackTrace();
		} catch (UnsupportedEncodingException aVdKsNvI) {
			aVdKsNvI.printStackTrace();
		}
		return null;
	}

}