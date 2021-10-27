class n18695230 {
	public static synchronized String encrypt(String EP0uhZv0)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest jDxVXmjt = MessageDigest.getInstance("SHA");
		jDxVXmjt.update(EP0uhZv0.getBytes("UTF-8"));
		byte NautYrhv[] = jDxVXmjt.digest();
		return new Base64(-1).encodeToString(NautYrhv);
	}

}