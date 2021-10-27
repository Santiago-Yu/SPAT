class n16820041 {
	public static String encodePassword(String _originalPassword) {
		String encodedPassword = null;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
			md.update(_originalPassword.getBytes("UTF-8"));
			encodedPassword = (new BASE64Encoder()).encode(md.digest());
		} catch (NoSuchAlgorithmException _e) {
			_e.printStackTrace();
		} catch (UnsupportedEncodingException _e) {
			_e.printStackTrace();
		}
		return encodedPassword;
	}

}