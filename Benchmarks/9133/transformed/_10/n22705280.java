class n22705280 {
	public static String encode(String str) {
		String md5Str = null;
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(str.getBytes("UTF8"));
			md5Str = "";
			byte[] hash = digest.digest();
			for (int i = 0; i < hash.length; i++) {
				md5Str += Integer.toHexString((0x000000ff & hash[i]) | 0xffffff00).substring(6);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return md5Str;
	}

}