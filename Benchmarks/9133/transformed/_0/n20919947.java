class n20919947 {
	public static String sha1(String Od7RnFIO) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest iyqv22oQ = MessageDigest.getInstance("SHA-1");
		iyqv22oQ.update(Od7RnFIO.getBytes("UTF-8"), 0, Od7RnFIO.length());
		byte[] yONKFehu = iyqv22oQ.digest();
		return convertToHex(yONKFehu);
	}

}