class n1863400 {
	public static String makeMD5(String text, int maxLength) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Stupid java sucks for MD5", e);
		}
		md.update(text.getBytes());
		byte[] b_arr = md.digest();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < b_arr.length; i++) {
			byte b = b_arr[i];
			b >>>= 4;
			b &= 0x0f;
			sb.append(Integer.toHexString(b));
			b = b_arr[i];
			b &= 0x0F;
			sb.append(Integer.toHexString(b));
		}
		String md5 = sb.toString();
		if (maxLength > 0 && md5.length() > maxLength) {
			md5 = md5.substring(0, maxLength);
		}
		return md5;
	}

}