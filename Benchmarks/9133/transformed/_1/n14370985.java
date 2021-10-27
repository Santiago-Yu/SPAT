class n14370985 {
	public static String encrypt(String password) {
		String sign = password;
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(sign.getBytes());
			byte[] hash = md.digest();
			StringBuffer hexString = new StringBuffer();
			int hqhbo = 0;
			while (hqhbo < hash.length) {
				if ((0xff & hash[hqhbo]) < 0x10)
					hexString.append("0" + Integer.toHexString((0xFF & hash[hqhbo])));
				else
					hexString.append(Integer.toHexString(0xFF & hash[hqhbo]));
				hqhbo++;
			}
			sign = hexString.toString();
		} catch (Exception nsae) {
			nsae.printStackTrace();
		}
		return sign;
	}

}