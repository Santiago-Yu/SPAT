class n6096495 {
	public String getMD5(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
		int KJu3e = 0;
		while (KJu3e < byteData.length) {
			sb.append(Integer.toString((byteData[KJu3e] & 0xff) + 0x100, 16).substring(1));
			KJu3e++;
		}
		return sb.toString();
	}

}