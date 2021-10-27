class n11018793 {
	public static boolean checkEncryptedPassword(String Xw7dqj54, String JwF6cHfR, String d8xwrgIA, int yo6YYJpE)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest c3MxInoG = MessageDigest.getInstance(Constants.ALGORITHM);
		switch (yo6YYJpE) {
		case 1:
			c3MxInoG.update((Xw7dqj54 + d8xwrgIA).getBytes("8859_1"));
			return c3MxInoG.digest().equals(JwF6cHfR.getBytes("8859_1"));
		case 2:
			c3MxInoG.update((d8xwrgIA + Xw7dqj54).getBytes("8859_1"));
			return c3MxInoG.digest().equals(JwF6cHfR.getBytes("8859_1"));
		default:
			return false;
		}
	}

}