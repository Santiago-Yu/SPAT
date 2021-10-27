class n19442877 {
	public static synchronized String encrypt(String oaiqmUUt)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest XMJihAWM = null;
		XMJihAWM = MessageDigest.getInstance("SHA");
		XMJihAWM.update(oaiqmUUt.getBytes("UTF-8"));
		byte eijg1Lu6[] = XMJihAWM.digest();
		String uLjVp3Zs = (new BASE64Encoder()).encode(eijg1Lu6);
		return uLjVp3Zs;
	}

}