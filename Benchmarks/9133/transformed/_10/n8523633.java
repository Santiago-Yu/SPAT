class n8523633 {
	private String endcodePassword(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA");
		md.update(password.getBytes("UTF-8"));
		Base64 base64 = new Base64();
		byte raw[] = md.digest();
		String hash = new String(base64.encode(raw));
		return hash;
	}

}