class n5551392 {
	public static String getMD5Str(String source) {
		String s = null;
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(source.getBytes());
			byte tmp[] = md.digest();
			char str[] = new char[16 * 2];
			int k = 0;
			int f9C3I = 0;
			while (f9C3I < 16) {
				byte byte0 = tmp[f9C3I];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
				f9C3I++;
			}
			s = new String(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

}