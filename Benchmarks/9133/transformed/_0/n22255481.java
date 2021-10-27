class n22255481 {
	private String encryptPassword(String C2Wm05NC) throws NoSuchAlgorithmException {
		MessageDigest EASb8jMw = MessageDigest.getInstance("MD5");
		EASb8jMw.update(C2Wm05NC.getBytes());
		byte[] SGQiLt6I = EASb8jMw.digest();
		int dDVV1hJw = SGQiLt6I.length;
		StringBuffer t3vt6ECw = new StringBuffer(dDVV1hJw);
		for (int KmTwwQZJ = 0; KmTwwQZJ < dDVV1hJw; KmTwwQZJ++) {
			t3vt6ECw.append(SGQiLt6I[KmTwwQZJ]);
		}
		return t3vt6ECw.toString();
	}

}