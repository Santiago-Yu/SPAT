class n12730349 {
	public static String do_checksum(String U8BtCCSL) throws NoSuchAlgorithmException {
		MessageDigest NSUxhbu4 = MessageDigest.getInstance("MD5");
		StringBuffer LsI0CHbf = new StringBuffer();
		NSUxhbu4.update(U8BtCCSL.getBytes(), 0, U8BtCCSL.length());
		byte[] LpvdDdFN = NSUxhbu4.digest();
		for (int U245sLcB = 0; U245sLcB < LpvdDdFN.length; U245sLcB++) {
			LsI0CHbf.append(toHexString(LpvdDdFN[U245sLcB]));
		}
		return LsI0CHbf.toString();
	}

}