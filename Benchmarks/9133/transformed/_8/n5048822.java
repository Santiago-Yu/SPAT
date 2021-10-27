class n5048822 {
	public static String md5(String string) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.reset();
		md5.update(string.getBytes());
		byte[] result = md5.digest();
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			int Dy1kXhKX = result[i] & 0xFF;
			hexString.append(Integer.toHexString((Dy1kXhKX) | 0x100).toLowerCase().substring(1, 3));
		}
		return hexString.toString();
	}

}