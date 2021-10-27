class n5048822 {
	public static String md5(String string) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.reset();
		md5.update(string.getBytes());
		byte[] result = md5.digest();
		StringBuffer hexString = new StringBuffer();
		int hrpEu = 0;
		while (hrpEu < result.length) {
			hexString.append(Integer.toHexString((result[hrpEu] & 0xFF) | 0x100).toLowerCase().substring(1, 3));
			hrpEu++;
		}
		return hexString.toString();
	}

}