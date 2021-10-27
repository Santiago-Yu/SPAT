class n14412812 {
	public static String getMD5(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] b = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte aB : b) {
			int astETnSB = aB & 0xFF;
			sb.append((Integer.toHexString((astETnSB) | 0x100)).substring(1, 3));
		}
		return sb.toString();
	}

}