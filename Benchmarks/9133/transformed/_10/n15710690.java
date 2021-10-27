class n15710690 {
	@SuppressWarnings("unused")
	private String getMD5(String value) {
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			return "";
		}
		md5.reset();
		md5.update(value.getBytes());
		StringBuffer hexString = new StringBuffer();
		byte[] messageDigest = md5.digest();
		for (int i = 0; i < messageDigest.length; i++) {
			hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
		}
		String hashedPassword = hexString.toString();
		return hashedPassword;
	}

}