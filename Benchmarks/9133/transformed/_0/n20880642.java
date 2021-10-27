class n20880642 {
	public static String getHash(String ei5qrqAw, String nSxGIQAV)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		logger.debug("Entering getHash with password = " + ei5qrqAw + "\n and salt = " + nSxGIQAV);
		MessageDigest O5rIVOCK = MessageDigest.getInstance("SHA-512");
		O5rIVOCK.reset();
		O5rIVOCK.update(nSxGIQAV.getBytes());
		byte[] PmWqkDLV = O5rIVOCK.digest(ei5qrqAw.getBytes("UTF-8"));
		String BKqDtTR2 = String.valueOf(PmWqkDLV);
		logger.debug("Exiting getHash with hasResult of " + BKqDtTR2);
		return BKqDtTR2;
	}

}