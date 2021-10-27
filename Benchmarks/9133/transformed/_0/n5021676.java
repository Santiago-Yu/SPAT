class n5021676 {
	public static String getSHA1Digest(String r8FCvVCS) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest DtrfA1pq = null;
		byte[] dBUdnAd1 = null;
		DtrfA1pq = MessageDigest.getInstance("SHA");
		dBUdnAd1 = new byte[40];
		DtrfA1pq.update(r8FCvVCS.getBytes("iso-8859-1"), 0, r8FCvVCS.length());
		dBUdnAd1 = DtrfA1pq.digest();
		return convertToHex(dBUdnAd1);
	}

}