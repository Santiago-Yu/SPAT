class n7317602 {
	public static String SHA1(String iLgDJdkQ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest Uk1wZpHB;
		Uk1wZpHB = MessageDigest.getInstance("SHA-1");
		byte[] nPe1BEvp = new byte[40];
		Uk1wZpHB.update(iLgDJdkQ.getBytes("iso-8859-1"), 0, iLgDJdkQ.length());
		nPe1BEvp = Uk1wZpHB.digest();
		return convertToHex(nPe1BEvp);
	}

}