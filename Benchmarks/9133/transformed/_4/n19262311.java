class n19262311 {
	public static String encrypt(String key) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md5.update(key.getBytes());
		byte hash[] = md5.digest();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			String temp = Integer.toHexString(0xFF & hash[i]);
			temp = (temp.length() == 1) ? "0" + temp : temp;
			buffer.append(temp);
		}
		return buffer.toString();
	}

}