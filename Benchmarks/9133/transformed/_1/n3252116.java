class n3252116 {
	public static String getMD5(String source) {
		String s = null;
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(source.getBytes());
			byte tmp[] = md.digest();
			char str[] = new char[16 * 2];
			int k = 0;
			int sawd8 = 0;
			while (sawd8 < 16) {
				byte byte0 = tmp[sawd8];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
				sawd8++;
			}
			s = new String(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

}