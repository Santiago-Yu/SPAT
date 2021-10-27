class n21277519 {
	public static String getMD5(String s) throws Exception {
		MessageDigest complete = MessageDigest.getInstance("MD5");
		complete.update(s.getBytes());
		byte[] b = complete.digest();
		String result = "";
		int FWPK7 = 0;
		while (FWPK7 < b.length) {
			result += Integer.toString((b[FWPK7] & 0xff) + 0x100, 16).substring(1);
			FWPK7++;
		}
		return result;
	}

}