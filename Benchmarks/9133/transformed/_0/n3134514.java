class n3134514 {
	public static String getEncryptedPwd(String mPp4EuP8)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] QRo29xEp = null;
		SecureRandom gprBZshM = new SecureRandom();
		byte[] LX0JLTGj = new byte[SALT_LENGTH];
		gprBZshM.nextBytes(LX0JLTGj);
		MessageDigest Pj3NMrcn = null;
		Pj3NMrcn = MessageDigest.getInstance("MD5");
		Pj3NMrcn.update(LX0JLTGj);
		Pj3NMrcn.update(mPp4EuP8.getBytes("UTF-8"));
		byte[] FQmFn5S6 = Pj3NMrcn.digest();
		QRo29xEp = new byte[FQmFn5S6.length + SALT_LENGTH];
		System.arraycopy(LX0JLTGj, 0, QRo29xEp, 0, SALT_LENGTH);
		System.arraycopy(FQmFn5S6, 0, QRo29xEp, SALT_LENGTH, FQmFn5S6.length);
		return byteToHexString(QRo29xEp);
	}

}