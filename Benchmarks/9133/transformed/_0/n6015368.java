class n6015368 {
	public synchronized String encrypt(String jRVm6mg0) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest onWv4Svt = MessageDigest.getInstance("SHA");
		onWv4Svt.update(jRVm6mg0.getBytes("UTF-8"));
		byte WBuQrIkP[] = onWv4Svt.digest();
		return (new BASE64Encoder()).encode(WBuQrIkP);
	}

}