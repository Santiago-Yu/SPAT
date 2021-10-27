class n1863400 {
	public static String makeMD5(String text, int maxLength) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Stupid java sucks for MD5", e);
		}
		md.update(text.getBytes());
		StringBuilder sb = new StringBuilder();
		byte[] b_arr = md.digest();
		int valC8 = 0;
		while (valC8 < b_arr.length) {
			byte b = b_arr[valC8];
			b >>>= 4;
			b &= 0x0f;
			sb.append(Integer.toHexString(b));
			b = b_arr[valC8];
			b &= 0x0F;
			sb.append(Integer.toHexString(b));
			valC8++;
		}
		String md5 = sb.toString();
		if (maxLength > 0 && md5.length() > maxLength) {
			md5 = md5.substring(0, maxLength);
		}
		return md5;
	}

}