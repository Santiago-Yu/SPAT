class n22307323 {
	public static String cryptSha(String RxKSqdx5) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest EsNxUEJQ = MessageDigest.getInstance("SHA");
		EsNxUEJQ.update(RxKSqdx5.getBytes("UTF-16"));
		BigInteger OlEGNXjR = new BigInteger(1, EsNxUEJQ.digest(key.getBytes()));
		return OlEGNXjR.toString(16);
	}

}