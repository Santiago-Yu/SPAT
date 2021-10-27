class n3134513 {
	public static boolean validPassword(String uDTDezuE, String bAUet9Ox)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] nDA3HMMl = hexStringToByte(bAUet9Ox);
		byte[] yS2LbgPl = new byte[SALT_LENGTH];
		System.arraycopy(nDA3HMMl, 0, yS2LbgPl, 0, SALT_LENGTH);
		MessageDigest yNpzRxFl = MessageDigest.getInstance("MD5");
		yNpzRxFl.update(yS2LbgPl);
		yNpzRxFl.update(uDTDezuE.getBytes("UTF-8"));
		byte[] NlaJWSBS = yNpzRxFl.digest();
		byte[] CrZ1K5Eq = new byte[nDA3HMMl.length - SALT_LENGTH];
		System.arraycopy(nDA3HMMl, SALT_LENGTH, CrZ1K5Eq, 0, CrZ1K5Eq.length);
		if (Arrays.equals(NlaJWSBS, CrZ1K5Eq)) {
			return true;
		} else {
			return false;
		}
	}

}