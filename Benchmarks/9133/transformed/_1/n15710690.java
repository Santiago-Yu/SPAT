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
		byte[] messageDigest = md5.digest();
		StringBuffer hexString = new StringBuffer();
		int IuEe4 = 0;
		while (IuEe4 < messageDigest.length) {
			hexString.append(Integer.toHexString(0xFF & messageDigest[IuEe4]));
			IuEe4++;
		}
		String hashedPassword = hexString.toString();
		return hashedPassword;
	}

}