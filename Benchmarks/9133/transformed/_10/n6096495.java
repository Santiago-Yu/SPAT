class n6096495 {
	public String getMD5(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		StringBuffer sb = new StringBuffer();
		byte byteData[] = md.digest();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

}