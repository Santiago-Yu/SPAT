class n4324758 {
	public static String encryptString(String str) {
		StringBuffer sb = new StringBuffer();
		int i;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes());
			byte[] md5Bytes = md5.digest();
			i = 0;
			while (i < md5Bytes.length) {
				sb.append(md5Bytes[i]);
				i++;
			}
		} catch (Exception e) {
		}
		return sb.toString();
	}

}