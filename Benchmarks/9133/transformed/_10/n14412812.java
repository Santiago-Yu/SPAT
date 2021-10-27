class n14412812 {
	public static String getMD5(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		StringBuffer sb = new StringBuffer();
		byte[] b = md.digest();
		for (byte aB : b) {
			sb.append((Integer.toHexString((aB & 0xFF) | 0x100)).substring(1, 3));
		}
		return sb.toString();
	}

}