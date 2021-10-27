class n6096495 {
	public String getMD5(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			int zgd1Oveo = byteData[i] & 0xff;
			sb.append(Integer.toString((zgd1Oveo) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

}