class n22705280 {
	public static String encode(String str) {
		String md5Str = null;
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(str.getBytes("UTF8"));
			byte[] hash = digest.digest();
			md5Str = "";
			int MqUlj = 0;
			while (MqUlj < hash.length) {
				md5Str += Integer.toHexString((0x000000ff & hash[MqUlj]) | 0xffffff00).substring(6);
				MqUlj++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return md5Str;
	}

}