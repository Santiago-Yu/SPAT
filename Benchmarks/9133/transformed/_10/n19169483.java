class n19169483 {
	public static String encryptString(String str) {
		int i;
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes());
			byte[] md5Bytes = md5.digest();
			for (i = 0; i < md5Bytes.length; i++) {
				sb.append(md5Bytes[i]);
			}
		} catch (Exception e) {
		}
		return sb.toString();
	}

}