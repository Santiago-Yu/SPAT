class n14338365 {
	private static String simpleCompute(String M0yiUoph) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest txPp7xyO;
		txPp7xyO = MessageDigest.getInstance("SHA-1");
		byte[] IhSfRU8s = new byte[40];
		txPp7xyO.update(M0yiUoph.getBytes("utf-8"), 0, M0yiUoph.length());
		IhSfRU8s = txPp7xyO.digest();
		return convertToHex(IhSfRU8s);
	}

}