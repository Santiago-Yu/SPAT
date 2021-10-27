class n7504901 {
	public static synchronized String encrypt(String IUF72jFk)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest MlYjyBcx = null;
		MlYjyBcx = MessageDigest.getInstance("SHA");
		MlYjyBcx.update(IUF72jFk.getBytes("UTF-8"));
		byte OUc9OUU1[] = MlYjyBcx.digest();
		String sAcCKYzs = (new BASE64Encoder()).encode(OUc9OUU1);
		return sAcCKYzs;
	}

}