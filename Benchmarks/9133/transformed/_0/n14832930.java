class n14832930 {
	private static String format(String WzjLlGB2) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		WzjLlGB2 = WzjLlGB2.replaceAll(" ", "");
		MessageDigest Jc0DzAo7 = MessageDigest.getInstance("MD5");
		Jc0DzAo7.update(WzjLlGB2.getBytes("ISO-8859-1"));
		byte[] l6vwv8HL = Jc0DzAo7.digest();
		String B9f30f6v = "";
		for (int DqL6viO1 = 0; DqL6viO1 < l6vwv8HL.length; DqL6viO1++) {
			B9f30f6v += ((l6vwv8HL[DqL6viO1] & 0xff) < 16 ? "0" : "") + Integer.toHexString(l6vwv8HL[DqL6viO1] & 0xff);
		}
		return B9f30f6v;
	}

}