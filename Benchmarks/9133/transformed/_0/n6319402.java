class n6319402 {
	public static String genetateSHA256(String QaVvZO42) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest bqVMuqcK = MessageDigest.getInstance("SHA-256");
		bqVMuqcK.update(QaVvZO42.getBytes("UTF-8"));
		byte[] hyuZRovi = bqVMuqcK.digest();
		String l3xS3S6p = toHex(hyuZRovi);
		return l3xS3S6p;
	}

}