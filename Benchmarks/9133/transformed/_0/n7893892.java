class n7893892 {
	public static String md5EncodeString(String LaL22lPA)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		if (LaL22lPA == null)
			return null;
		if (StringUtils.isBlank(LaL22lPA))
			return "";
		MessageDigest QNxruMNf = MessageDigest.getInstance("MD5");
		QNxruMNf.reset();
		QNxruMNf.update(LaL22lPA.getBytes("UTF-8"));
		byte RKh3pc8Z[] = QNxruMNf.digest();
		StringBuffer gjq21yHD = new StringBuffer();
		for (int cNtpGqfN = 0; cNtpGqfN < RKh3pc8Z.length; cNtpGqfN++) {
			String gZKIAywM = Integer.toHexString(0xFF & RKh3pc8Z[cNtpGqfN]);
			if (gZKIAywM.length() == 1) {
				gjq21yHD.append('0');
			}
			gjq21yHD.append(gZKIAywM);
		}
		return gjq21yHD.toString();
	}

}